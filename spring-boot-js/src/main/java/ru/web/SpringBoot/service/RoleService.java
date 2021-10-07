package ru.web.SpringBoot.service;


import ru.web.SpringBoot.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role findByName(String name);

    void save(Role role);
}
