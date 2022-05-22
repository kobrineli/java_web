package ru.msu.cmc.java_web.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.msu.cmc.java_web.DAO.adminDAO;
import ru.msu.cmc.java_web.DAO.impl.adminDAOimpl;
import ru.msu.cmc.java_web.DAO.impl.readersDAOimpl;
import ru.msu.cmc.java_web.DAO.readersDAO;
import ru.msu.cmc.java_web.models.admin;
import ru.msu.cmc.java_web.models.readers;

import java.util.List;

@Controller
public class log_in {

    private final readersDAO readersDAO_ = new readersDAOimpl();
    private final adminDAO adminDAO_ = new adminDAOimpl();

    @GetMapping("/submit_log_in")
    public String submit_log_in(@RequestParam(name = "login") String login,
                                @RequestParam(name = "password") String password,
                                Model model) {
        List<readers> lst =  readersDAO_.get_all_readers();
        for (int i = 0; i < lst.size(); ++i) {
            if (lst.get(i).getReader_login().equals(login)) {
                if (lst.get(i).getReader_password().equals(password)) {
                    model.addAttribute("readerId", lst.get(i).getLibrary_card_number());
                    return "redirect:/reg-main";
                }
                else {
                    return "redirect:/index";
                }
            }
        }

        List<admin> adms = adminDAO_.get_all_admins();
        for (int i = 0; i < adms.size(); ++i) {
            if (adms.get(i).getAdmin_login().equals(login)) {
                if (adms.get(i).getAdmin_password().equals(password)) {
                    return "redirect:/admin-main";
                }
                else {
                    return "redirect:/index";
                }
            }
        }

        return "redirect:/index";
    }

    @GetMapping("/log_out")
    public String log_out() {
        return "redirect:/index";
    }
}
