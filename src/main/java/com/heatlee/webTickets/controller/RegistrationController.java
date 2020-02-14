package com.heatlee.webTickets.controller;

import com.heatlee.webTickets.model.entity.Role;
import com.heatlee.webTickets.model.entity.User;
import com.heatlee.webTickets.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            User user,
            Map<String, Object> model
    ) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (user.getUsername().equals("admin") && userFromDb == null) {
            user.setActive(true);
            user.setPassword("1234567810");
            user.setRoles(Collections.singleton(Role.ADMIN));
            userRepo.save(user);
            return "redirect:/login";
        }

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            model.put("message", "Empty username or password unsupported!");
            return "registration";
        }

        if (!isValidUsername(user.getUsername()) || !isValidPassword(user.getPassword())) {
            model.put("message", "Invalid length. Username(5-20), Password(8-16)");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }

    private static boolean isValidUsername(String username) {
        return username.length() >= 5 && username.length() <= 20;
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.length() <= 16;
    }
}