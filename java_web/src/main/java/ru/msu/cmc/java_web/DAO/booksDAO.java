package ru.msu.cmc.java_web.DAO;

import ru.msu.cmc.java_web.models.books;

import java.util.List;

public interface booksDAO {
    void add_book(books book);
    void update_book(books book);
    void delete_book(books book);

    books get_book_by_id(Long id);
    List<books> get_all_books();
    List<books> get_books_by_name(String name);
    List<books> get_books_by_author(String author);
    List<books> get_books_by_copies();
    List<books> get_books_by_publisher(String publisher);
    List<books> get_books_by_year(Long year);
}
