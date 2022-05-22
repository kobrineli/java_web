package ru.msu.cmc.java_web.DAO.impl;

import org.hibernate.query.Query;
import ru.msu.cmc.java_web.DAO.book_copiesDAO;
import ru.msu.cmc.java_web.models.book_copies;
import org.hibernate.Session;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.utils.HibernateUtil;

import java.util.List;

public class book_copiesDAOimpl implements book_copiesDAO {
    @Override
    public void add_book_copies(book_copies copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update_book_copies(book_copies copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete_book_copies(book_copies copy) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(copy);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public book_copies get_copy_by_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<book_copies> query = session.createQuery("FROM book_copies WHERE copy_id = :id", book_copies.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
    }

    @Override
    public List<book_copies> get_all_copies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<book_copies> query = session.createQuery("FROM book_copies ", book_copies.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<book_copies> get_copy_by_book_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<book_copies> query = session.createQuery("FROM book_copies WHERE book_id.book_id = :id", book_copies.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }
}
