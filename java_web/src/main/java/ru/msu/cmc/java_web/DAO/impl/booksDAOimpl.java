package ru.msu.cmc.java_web.DAO.impl;

import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.models.books;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.msu.cmc.java_web.utils.HibernateUtil;

import java.util.List;

public class booksDAOimpl implements booksDAO {
    @Override
    public void add_book(books book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update_book(books book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete_book(books book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(book);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public books get_book_by_id(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books WHERE book_id = :id", books.class)
                .setParameter("id", id);
        return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
    }

    @Override
    public List<books> get_all_books() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books", books.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<books> get_books_by_name(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books WHERE book_name LIKE :name", books.class)
                .setParameter("name", likeExpr(name));
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<books> get_books_by_author(String author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books WHERE authors LIKE :author", books.class)
                .setParameter("author", likeExpr(author));
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<books> get_books_by_copies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books ORDER BY total_amount", books.class);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<books> get_books_by_publisher(String publisher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books WHERE publisher LIKE :publisher", books.class)
                .setParameter("publisher", likeExpr(publisher));
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    @Override
    public List<books> get_books_by_year(Long year) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<books> query = session.createQuery("FROM books WHERE publish_year = :year", books.class)
                .setParameter("year", year);
        return query.getResultList().size() == 0 ? null : query.getResultList();
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}
