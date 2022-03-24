package DAO;

import models.reader_story;
import models.readers;

import java.util.List;

public interface reader_storyDAO {
    void add_reader_story(reader_story record);
    void update_reader_story(reader_story record);
    void delete_reader_story(reader_story record);

    List<reader_story> get_reader_story_by_reader(readers reader);
    List<reader_story> get_all_reader_story();
}
