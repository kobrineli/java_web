package ru.msu.cmc.java_web.DAO;

import ru.msu.cmc.java_web.models.book_copies;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

public interface book_copiesDAO {
    void add_book_copies(book_copies copy);
    void update_book_copies(book_copies copy);
    void delete_book_copies(book_copies copy);

    book_copies get_copy_by_id(Long id);
    List<book_copies> get_all_copies();
}
