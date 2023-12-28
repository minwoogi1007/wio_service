package com.twocrm.controller;

import com.twocrm.model.User;
import com.twocrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findUserByUsername(username);
        System.out.println("getPassword"+user.getPassword());
        System.out.println("getUsername"+user.getUsername());
        System.out.println("getId"+user.getId());
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            model.addAttribute("username", username);
            System.out.println("user 로그인 성공"+user);
            return "home";
        } else {
            model.addAttribute("loginError", true);
            return "login";
        }
    }
}