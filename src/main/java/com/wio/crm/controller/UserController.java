package com.wio.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login"; // 로그인 페이지로 리디렉트
    }

    // 추가적인 컨트롤러 메서드
}
