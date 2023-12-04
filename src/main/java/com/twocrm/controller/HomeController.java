package com.twocrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "login"; // 기본 페이지로 로그인 페이지 설정
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main"; // 메인 페이지 (로그인 성공 후 이동)
    }
}
