package ru.msu.cmc.java_web.DAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.msu.cmc.java_web.DAO.impl.adminDAOimpl;
import ru.msu.cmc.java_web.JavaWebApplication;
import ru.msu.cmc.java_web.models.admin;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class adminDAOtest {

    @Test
    public void add_update_delete_admin_test() {
        adminDAOimpl adminDAO = new adminDAOimpl();
        List<admin> list = adminDAO.get_all_admins();
        admin ad = new admin(list.size() + 1, "admin", "admin");
        adminDAO.add_admin(ad);
        admin new_ad = adminDAO.get_admin_by_id((long) (list.size() + 1));
        assertEquals(new_ad.getAdmin_id(), ad.getAdmin_id());


        ad.setAdmin_login("login");
        adminDAO.update_admin(ad);
        new_ad = adminDAO.get_admin_by_id((long) (list.size() + 1));
        assertEquals(ad.getAdmin_id(), new_ad.getAdmin_id());

        adminDAO.delete_admin(ad);
        assertEquals(adminDAO.get_all_admins().size(), list.size());
    }
}
