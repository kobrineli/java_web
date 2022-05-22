package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.DAO.readersDAO;
import ru.msu.cmc.java_web.models.readers;

import java.util.List;

@Controller
public class sign_up {

    private final readersDAO readersDAO_ = new readersDAOimpl();

    @RequestMapping("/submit_sign_up")
    public String submit_sign_up(@RequestParam(name="login") String login,
                                 @RequestParam(name="surname") String surname,
                                 @RequestParam(name="name") String name,
                                 @RequestParam(name="patr") String patr,
                                 @RequestParam(name="address") String address,
                                 @RequestParam(name="password") String password,
                                 Model model) {
        List<readers> lst = readersDAO_.get_all_readers();
        readers new_reader = new readers(lst.size() + 1, surname, name, patr, address, login, password);
        readersDAO_.add_readers(new_reader);
        return "redirect:/reg-main";
    }
}
