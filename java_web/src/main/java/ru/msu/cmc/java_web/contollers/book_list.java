package ru.msu.cmc.java_web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

@Controller
public class book_list {

    private final booksDAO booksDAO_ = new booksDAOimpl();

    @GetMapping(value = {"/reg-main", "/admin-main"})
    public String book_list(Model model) {
        List<books> lst = (List<books>) booksDAO_.get_all_books();
        model.addAttribute("books", lst);
        return "book_list";
    }
}
