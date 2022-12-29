package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser (User user);
    void updateUser(User updateUser);

    void deleteUser(long id);

    User findByUsername (String username);

}
