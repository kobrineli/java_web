package DAO.impl;

import DAO.adminDAO;
import models.admin;
import org.hibernate.Session;
import utils.HibernateUtil;

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
}
