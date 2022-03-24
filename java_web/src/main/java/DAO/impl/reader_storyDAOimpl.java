package DAO.impl;

import DAO.reader_storyDAO;
import models.reader_story;
import models.readers;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class reader_storyDAOimpl implements reader_storyDAO {
    @Override
    public void add_reader_story(reader_story record) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(record);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update_reader_story(reader_story record) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(record);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete_reader_story(reader_story record) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(record);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<reader_story> get_reader_story_by_reader(readers reader) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<reader_story> query = session.createQuery("FROM reader_story WHERE reader_id = :id", reader_story.class)
                .setParameter("id", reader.getLibrary_card_number());
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<reader_story> get_all_reader_story() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<reader_story> query = session.createQuery("FROM reader_story", reader_story.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }
}
