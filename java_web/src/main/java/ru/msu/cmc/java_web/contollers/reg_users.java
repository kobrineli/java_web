package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.book_copiesDAO;
import ru.msu.cmc.java_web.DAO.booksDAO;
import ru.msu.cmc.java_web.DAO.impl.book_copiesDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.booksDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.reader_storyDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.DAO.reader_storyDAO;
import ru.msu.cmc.java_web.DAO.readersDAO;
import ru.msu.cmc.java_web.models.reader_story;
import ru.msu.cmc.java_web.models.readers;

import java.util.List;

@Controller
public class reg_users {

    private final readersDAO readersDAO_ = new readersDAOimpl();
    private final book_copiesDAO book_copiesDAO_ = new book_copiesDAOimpl();
    private final reader_storyDAO reader_storyDAO_ = new reader_storyDAOimpl();
    private final booksDAO booksDAO_ = new booksDAOimpl();

    @GetMapping(value="/profile")
    public String profile(Model model) {
        readers reader = readersDAO_.get_reader_by_id(1L);
        model.addAttribute("surname", reader.getSurname());
        model.addAttribute("name", reader.getName());
        model.addAttribute("patr", reader.getPatronymic());
        model.addAttribute("address", reader.getAddress());
        model.addAttribute("login", reader.getReader_login());
        model.addAttribute("password", reader.getReader_password());
        return "profile";
    }

    @GetMapping(value="/history")
    public String history(Model model) {
        List<reader_story> story = reader_storyDAO_.get_story_by_reader_id(1L);
        model.addAttribute("stories", story);
        return "history";
    }
}
