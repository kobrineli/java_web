package DAO.impl;

import DAO.book_copiesDAO;
import models.book_copies;
import org.hibernate.Session;
import utils.HibernateUtil;

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
}
