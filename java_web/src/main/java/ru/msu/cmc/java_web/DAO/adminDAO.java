package ru.msu.cmc.java_web.DAO;

import ru.msu.cmc.java_web.models.admin;
import ru.msu.cmc.java_web.models.books;

import java.util.List;

public interface adminDAO {
    void add_admin(admin adm);
    void update_admin(admin adm);
    void delete_admin(admin adm);

    admin get_admin_by_id(Long id);
    List<admin> get_all_admins();
}
