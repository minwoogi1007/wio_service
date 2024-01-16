package com.wio.crm.controller;

import com.wio.crm.model.Menu;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(Model model, HttpSession session) {
        // Retrieve menus from the session
        List<Menu> userMenus = (List<Menu>) session.getAttribute("userMenus");
        model.addAttribute("userMenus", userMenus);
        return "main"; // s
    }
}
