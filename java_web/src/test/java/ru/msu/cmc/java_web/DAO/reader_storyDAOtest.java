package ru.msu.cmc.java_web.DAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.DAO.impl.book_copiesDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.reader_storyDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.JavaWebApplication;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.reader_story;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class reader_storyDAOtest {

    @Test
    public void add_update_delete_story_test() {
        readersDAOimpl readersDAO = new readersDAOimpl();
        book_copiesDAOimpl copiesDAO = new book_copiesDAOimpl();

        reader_storyDAOimpl storyDAO = new reader_storyDAOimpl();
        List<reader_story> list = storyDAO.get_all_reader_story();
        reader_story story = new reader_story(list.size() + 1, readersDAO.get_reader_by_id(1L), copiesDAO.get_copy_by_id(1L), LocalDate.now(), LocalDate.now());
        storyDAO.add_reader_story(story);
        reader_story new_story = storyDAO.get_story_by_id((long) list.size() + 1);
        assertEquals(new_story.getId(), story.getId());


        story.setReader_id(readersDAO.get_reader_by_id(1L));
        storyDAO.update_reader_story(story);
        new_story = storyDAO.get_story_by_id((long) (list.size() + 1));
        assertEquals(story.getId(), new_story.getId());

        storyDAO.delete_reader_story(story);
        assertEquals(storyDAO.get_all_reader_story().size(), list.size());
    }
}
