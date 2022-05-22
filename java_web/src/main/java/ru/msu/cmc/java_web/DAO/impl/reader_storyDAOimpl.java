package ru.msu.cmc.java_web.DAO.impl;

import ru.msu.cmc.java_web.DAO.reader_storyDAO;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.reader_story;
import ru.msu.cmc.java_web.models.readers;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.java_web.utils.HibernateUtil;

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
    public List<reader_story> get_all_reader_story() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<reader_story> query = session.createQuery("FROM reader_story", reader_story.class);
        List<reader_story> list = query.getResultList();
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public reader_story get_story_by_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<reader_story> query = session.createQuery("FROM reader_story WHERE id = :id", reader_story.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
    }

    @Override
    public List<reader_story> get_story_by_reader_id(Long id) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        Query<reader_story> query = session.createQuery("FROM reader_story WHERE reader_id.id = :id", reader_story.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }
}
