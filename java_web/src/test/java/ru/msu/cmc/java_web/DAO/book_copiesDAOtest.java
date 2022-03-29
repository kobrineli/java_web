package ru.msu.cmc.java_web.DAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.DAO.impl.book_copiesDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.JavaWebApplication;
import ru.msu.cmc.java_web.models.book_copies;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class book_copiesDAOtest {

    @Test
    public void add_update_delete_copy_test() {
        booksDAOimpl booksDAO = new booksDAOimpl();

        book_copiesDAOimpl book_copiesDAO = new book_copiesDAOimpl();
        List<book_copies> list = book_copiesDAO.get_all_copies();
        book_copies copy = new book_copies(list.size() + 1, booksDAO.get_book_by_id(1L), 10);
        book_copiesDAO.add_book_copies(copy);
        book_copies new_copy = book_copiesDAO.get_copy_by_id((long) (list.size() + 1));
        assertEquals(new_copy.getCopy_id(), copy.getCopy_id());


        copy.setCopy_number(5);
        book_copiesDAO.update_book_copies(copy);
        new_copy = book_copiesDAO.get_copy_by_id((long) (list.size() + 1));
        assertEquals(copy.getCopy_id(), new_copy.getCopy_id());

        book_copiesDAO.delete_book_copies(copy);
        assertEquals(book_copiesDAO.get_all_copies().size(), list.size());
    }
}
