package com.wio.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // 루트 URL 접근 시 로그인 페이지로 리디렉션
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html 뷰로 리디렉션
    }
}
