package DAO;

import models.book_copies;

public interface book_copiesDAO {
    void add_book_copies(book_copies copy);
    void update_book_copies(book_copies copy);
    void delete_book_copies(book_copies copy);
}
