package ru.msu.cmc.java_web.DAO;

import ru.msu.cmc.java_web.models.readers;

import java.util.List;

public interface readersDAO {
    void add_readers(readers reader);
    void update_readers(readers reader);
    void delete_readers(readers reader);

    readers get_reader_by_id(Long id);
    List<readers> get_all_readers();
    readers get_reader_by_login(String login);
}
