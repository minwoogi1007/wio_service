package com.wio.crm.controller;

import com.wio.crm.mapper.TipdwMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;


@Controller
public class LoginController {
    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // 루트 URL 접근 시 로그인 페이지로 리디렉션
    }

    @GetMapping("/login")
    public String login() {
        return "sign-in"; // sign-in.html 뷰로 리디렉션
    }

    @Autowired
    private TipdwMapper tipdwMapper;

    @GetMapping("/check-userid-availability")
    @ResponseBody
    public Map<String, Boolean> checkUserIdAvailability(@RequestParam String userId) {
        int count = tipdwMapper.countByUserId(userId);
        boolean isAvailable = count == 0; // userId가 존재하지 않으면 사용 가능
        return Collections.singletonMap("isAvailable", isAvailable);
    }
}
