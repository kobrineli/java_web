package ru.msu.cmc.java_web.DAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.JavaWebApplication;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class booksDAOtest {

    @Test
    public void add_update_delete_book_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        List<books> list = booksDAO.get_all_books();
        books book = new books(list.size() + 1, "Name", "Author", "Publisher", 2022, 123, 10, 10);
        booksDAO.add_book(book);
        books new_book = booksDAO.get_book_by_id((long) (list.size() + 1));
        assertEquals(new_book.getBook_id(), book.getBook_id());


        book.setBook_name("Not name");
        booksDAO.update_book(book);
        new_book = booksDAO.get_book_by_id((long) (list.size() + 1));
        assertEquals(book.getBook_id(), new_book.getBook_id());

        booksDAO.delete_book(book);
        assertEquals(booksDAO.get_all_books().size(), list.size());
    }

    @Test
    public void get_book_by_name_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        books book = booksDAO.get_books_by_name("Ктулху").get(0);
        assertEquals(book.getBook_name(), "Зов Ктулху");
    }

    @Test
    public void get_book_by_author_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        books book = booksDAO.get_books_by_author("Лавкрафт").get(0);
        assertEquals(book.getAuthors(), "Лавкрафт");
    }

    @Test
    public void get_book_by_copies_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        books book = booksDAO.get_books_by_copies().get(0);
        assertEquals(book.getTotal_amount(), 1);
    }

    @Test
    public void get_books_by_publisher_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        books book = booksDAO.get_books_by_publisher("Манн").get(0);
        assertEquals(book.getPublisher(), "Лабирин Манн");
    }

    @Test
    public void get_books_by_year_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        books book = booksDAO.get_books_by_year(2004L).get(0);
        assertEquals(book.getPublish_year(), 2004);
    }
}
