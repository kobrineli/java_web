package ru.msu.cmc.java_web.DAO;

import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.reader_story;
import ru.msu.cmc.java_web.models.readers;

import java.util.List;

public interface reader_storyDAO {
    void add_reader_story(reader_story record);
    void update_reader_story(reader_story record);
    void delete_reader_story(reader_story record);

    List<reader_story> get_all_reader_story();
    reader_story get_story_by_id(Long id);
}
