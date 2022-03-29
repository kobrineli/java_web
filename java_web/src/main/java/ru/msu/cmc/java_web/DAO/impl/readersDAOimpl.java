package ru.msu.cmc.java_web.DAO.impl;

import org.hibernate.query.Query;
import ru.msu.cmc.java_web.DAO.readersDAO;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.readers;
import org.hibernate.Session;
import ru.msu.cmc.java_web.utils.HibernateUtil;

import java.util.List;

public class readersDAOimpl implements readersDAO {
    @Override
    public void add_readers(readers reader) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update_readers(readers reader) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete_readers(readers reader) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(reader);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public readers get_reader_by_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<readers> query = session.createQuery("FROM readers WHERE library_card_number = :id", readers.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
    }

    @Override
    public List<readers> get_all_readers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<readers> query = session.createQuery("FROM readers ", readers.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }
}
