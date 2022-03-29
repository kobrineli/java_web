package ru.msu.cmc.java_web.DAO.impl;

import org.hibernate.query.Query;
import ru.msu.cmc.java_web.DAO.adminDAO;
import ru.msu.cmc.java_web.models.admin;
import org.hibernate.Session;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.utils.HibernateUtil;

import java.util.List;

public class adminDAOimpl implements adminDAO {
    @Override
    public void add_admin(admin adm) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(adm);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update_admin(admin adm) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(adm);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete_admin(admin adm) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(adm);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public admin get_admin_by_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<admin> query = session.createQuery("FROM admin WHERE admin_id = :id", admin.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
    }

    @Override
    public List<admin> get_all_admins() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<admin> query = session.createQuery("FROM admin", admin.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }
}
