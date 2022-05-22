package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.models.books;

@Controller
public class book_page {

    private final booksDAO booksDAO_ = new booksDAOimpl();

    @GetMapping("/book")
    public String bookPage(@RequestParam(name = "bookId") Long bookId,
                           Model model) {
        books book = booksDAO_.get_book_by_id(bookId);
        model.addAttribute("name", book.getBook_name());
        model.addAttribute("authors", book.getAuthors());
        model.addAttribute("publisher", book.getPublisher());
        model.addAttribute("year", book.getPublish_year());
        model.addAttribute("isbn", book.getIsbn());
        model.addAttribute("total", book.getTotal_amount());
        model.addAttribute("curr", book.getCurrent_count());
        return "book";
    }
}
