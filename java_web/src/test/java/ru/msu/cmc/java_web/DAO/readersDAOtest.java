package ru.msu.cmc.java_web.DAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.JavaWebApplication;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.readers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class readersDAOtest {

    @Test
    public void add_update_delete_reader_test() {
        readersDAOimpl readersDAO = new readersDAOimpl();
        List<readers> list = readersDAO.get_all_readers();
        readers reader = new readers(list.size() + 1, "Surname", "Name", "Patr", "address", "login", "password");
        readersDAO.add_readers(reader);
        readers new_reader = readersDAO.get_reader_by_id((long) (list.size() + 1));
        assertEquals(new_reader.getLibrary_card_number(), reader.getLibrary_card_number());


        reader.setName("Not name");
        readersDAO.update_readers(reader);
        new_reader = readersDAO.get_reader_by_id((long) (list.size() + 1));
        assertEquals(reader.getLibrary_card_number(), new_reader.getLibrary_card_number());

        readersDAO.delete_readers(reader);
        assertEquals(readersDAO.get_all_readers().size(), list.size());
    }
}
