package ru.msu.cmc.java_web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

@Controller
public class book_list {

    private final booksDAO booksDAO_ = new booksDAOimpl();

    @GetMapping(value = {"/reg-main"})
    public String reg_book_list(Model model) {
        List<books> lst = (List<books>) booksDAO_.get_all_books();
        model.addAttribute("books", lst);
        return "reg-main";
    }

    @GetMapping(value = {"/admin-main"})
    public String admin_book_list(Model model) {
        List<books> lst = (List<books>) booksDAO_.get_all_books();
        model.addAttribute("books", lst);
        return "admin-main";
    }

    @GetMapping(value = "/submit_filter")
    public String submit_filter(@RequestParam(name = "filter") String filter,
                                @RequestParam(name = "input_filter", required = false) String input,
                                Model model) {
        List<books> lst;
        switch (filter) {
            case "1":
                lst = (List<books>) booksDAO_.get_books_by_name(input);
                break;
            case "2":
                lst = (List<books>) booksDAO_.get_books_by_author(input);
                break;
            case "3":
                lst = (List<books>) booksDAO_.get_books_by_copies();
                break;
            case "4":
                lst = (List<books>) booksDAO_.get_books_by_publisher(input);
                break;
            case "5":
                lst = (List<books>) booksDAO_.get_books_by_year(Long.parseLong(input));
                break;
            default:
                lst = (List<books>) booksDAO_.get_all_books();
                break;
        }
        if (lst == null) {
            lst = booksDAO_.get_all_books();
        }
        model.addAttribute("books", lst);
        return "index";
    }
}
