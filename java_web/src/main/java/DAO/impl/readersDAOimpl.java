package DAO.impl;

import DAO.readersDAO;
import models.readers;
import org.hibernate.Session;
import utils.HibernateUtil;

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
}
