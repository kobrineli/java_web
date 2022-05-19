package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

@Controller
public class header_elements {

    private final booksDAO booksDAO_ = new booksDAOimpl();

    @GetMapping(value = { "/", "/index"})
    public String index(Model model) {
        List<books> lst = (List<books>) booksDAO_.get_all_books();
        model.addAttribute("books", lst);
        return "index";
    }

    @GetMapping(value = {"/log_in"})
    public String log_in() { return "log_in"; }

    @GetMapping(value = {"/sign_up"})
    public String sign_up() { return "sign_up"; }
}
