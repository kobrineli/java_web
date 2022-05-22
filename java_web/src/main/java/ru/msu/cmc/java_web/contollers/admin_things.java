package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.book_copiesDAO;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.book_copiesDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.reader_storyDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.DAO.reader_storyDAO;
import ru.msu.cmc.java_web.DAO.readersDAO;
import ru.msu.cmc.java_web.models.book_copies;
import ru.msu.cmc.java_web.models.books;
import ru.msu.cmc.java_web.models.reader_story;
import ru.msu.cmc.java_web.models.readers;

import java.time.LocalDate;
import java.util.List;

@Controller
public class admin_things {

    private final readersDAO readersDAO_ = new readersDAOimpl();
    private final booksDAO booksDAO_ = new booksDAOimpl();
    private final reader_storyDAO reader_storyDAO_ = new reader_storyDAOimpl();
    private final book_copiesDAO book_copiesDAO_ = new book_copiesDAOimpl();

    @GetMapping("add-reader")
    public String add_reader() {
        return "add-reader";
    }

    @GetMapping("add-book")
    public String add_book() {
        return "add-book";
    }

    @GetMapping("add-record")
    public String add_record() {
        return "add-record";
    }

    @RequestMapping("/submit_add_reader")
    public String submit_add_reader(@RequestParam(name="login") String login,
                                 @RequestParam(name="surname") String surname,
                                 @RequestParam(name="name") String name,
                                 @RequestParam(name="patr") String patr,
                                 @RequestParam(name="address") String address,
                                 @RequestParam(name="password") String password,
                                 Model model) {
        List<readers> lst = readersDAO_.get_all_readers();
        readers new_reader = new readers(lst.size() + 1, surname, name, patr, address, login, password);
        readersDAO_.add_readers(new_reader);
        return "redirect:/admin-main";
    }

    @GetMapping("/readers")
    public String readers(Model model) {
        List<readers> lst = readersDAO_.get_all_readers();
        model.addAttribute("readers", lst);
        return "readers";
    }

    @GetMapping("/remove_reader")
    public String remove_reader(@RequestParam(name="readerId") Long readerId,
                                Model model) {
        readersDAO_.delete_readers(readersDAO_.get_reader_by_id(readerId));
        return "redirect:/readers";
    }

    @RequestMapping("/submit_add_book")
    public String submit_add_reader(@RequestParam(name="name") String name,
                                    @RequestParam(name="authors") String authors,
                                    @RequestParam(name="publisher") String publisher,
                                    @RequestParam(name="year") String year,
                                    @RequestParam(name="isbn") String isbn,
                                    @RequestParam(name="total") String total) {
        List<books> lst = booksDAO_.get_all_books();
        books new_book = new books(lst.size() + 1, name, authors, publisher,
                Long.parseLong(year), Long.parseLong(isbn), Long.parseLong(total), Long.parseLong(total));
        booksDAO_.add_book(new_book);
        return "redirect:/admin-main";
    }

    @GetMapping("/remove_book")
    public String remove_book(@RequestParam(name="bookId") Long bookId,
                                Model model) {
        booksDAO_.delete_book(booksDAO_.get_book_by_id(bookId));
        return "redirect:/admin-main";
    }

    @RequestMapping("/submit_add_record")
    public String submit_add_record(@RequestParam(name="book_name") String book_name,
                                    @RequestParam(name="login") String login,
                                    @RequestParam(name="issue_date") String issue_date,
                                    @RequestParam(name="return_date") String return_date) {
        List<reader_story> story = reader_storyDAO_.get_all_reader_story();
        books book = booksDAO_.get_books_by_name(book_name).get(0);
        book_copies copy_id = book_copiesDAO_.get_copy_by_book_id(book.getBook_id()).get(0);
        readers reader_id = readersDAO_.get_reader_by_login(login);
        reader_story new_story = new reader_story(story.size() + 1, reader_id, copy_id,
                LocalDate.parse(issue_date), LocalDate.parse(return_date));
        reader_storyDAO_.add_reader_story(new_story);
        return "redirect:/admin-main";
    }
}
