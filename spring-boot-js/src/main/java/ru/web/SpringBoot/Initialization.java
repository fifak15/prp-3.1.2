package ru.web.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.web.SpringBoot.model.Role;
import ru.web.SpringBoot.model.User;
import ru.web.SpringBoot.service.RoleService;
import ru.web.SpringBoot.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initialization {
    UserService userService;
    RoleService roleService;

    @Autowired
    public Initialization(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role admin = new Role(1L, "ROLE_ADMIN");
        Role user = new Role(2L, "ROLE_USER");

        roleService.save(admin);
        roleService.save(user);

        Set<Role> allAccess = new HashSet<>();
        Set<Role> userAccess = new HashSet<>();

        allAccess.add(admin);
        allAccess.add(user);

        userAccess.add(user);

        User user1 = new User("admin", "admin", "Admin", "Adminov", (byte) 35, "admin@adminov.com", allAccess);
        User user2 = new User("qwerty", "qwerty", "Qwerty", "Adminov", (byte) 36, "qwerty@gmail.com", userAccess);
        User user3 = new User("user", "user", "User1", "Userov", (byte) 30, "user@gmail.com", userAccess);
        User user4 = new User("rick", "rick", "Rickardo", "Milos", (byte) 39, "rick@gmail.com", userAccess);
        User user5 = new User("alex", "alex", "Alex", "Smirnov", (byte) 99, "alex@gmail.com", allAccess);
        User user6 = new User("impostor", "impostor", "Impostor", "Imposter", (byte) 9, "imp@mail.ru", userAccess);
        User user7 = new User("bad", "bad", "Bad", "Comedian", (byte) 66, "bad@rambbler.net", userAccess);
        User user8 = new User("morty", "morty", "Morty", "Morty", (byte) 12, "morty@gmail.com", userAccess);
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);
    }

}
