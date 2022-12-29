package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser (long id);

    void removeUser (long id);

    void updateUser (User user);

    User findByUsername (String username);

}
