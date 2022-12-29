package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.ServiceDetails;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    private ServiceDetails serviceDetails;

    @Autowired
    public UserController(UserService userService, ServiceDetails serviceDetails) {
        this.userService = userService;
        this.serviceDetails = serviceDetails;
    }

    @GetMapping("/info")
    public String edit(Model model, Principal principal) {
        model.addAttribute("user", serviceDetails.loadUserByUsername(principal.getName()));
        return "user";
    }
}
