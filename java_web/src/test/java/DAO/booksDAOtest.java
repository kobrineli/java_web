package DAO;

import DAO.impl.booksDAOimpl;
import models.books;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.JavaWebApplication;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JavaWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations= "classpath:application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class booksDAOtest {

    @Test
    public void add_update_delete_book_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();
        List<books> list = booksDAO.get_all_books();
        books book = new books(list.size() + 1, "Name", "Author", "Publisher", 2022, 123, 10, 10);
        booksDAO.add_book(book);
        books new_book = booksDAO.get_book_by_id((long) (list.size() + 1));
        assertEquals(book, new_book);

        book.setBook_name("Not name");
        booksDAO.update_book(book);
        new_book = booksDAO.get_book_by_id((long) (list.size() + 1));
        assertEquals(book, new_book);

        booksDAO.delete_book(book);
        assertEquals(booksDAO.get_all_books().size(), list.size());
    }
}
