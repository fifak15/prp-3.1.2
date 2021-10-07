package ru.web.SpringBoot.service;


import ru.web.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    void delete(Long id);

    User getById(Long id);

    User getByLogin(String login);
}
