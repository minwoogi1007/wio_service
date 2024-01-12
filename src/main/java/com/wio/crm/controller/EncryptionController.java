package com.wio.crm.controller;

import com.wio.crm.service.CustomUserDetailsService;
import com.wio.crm.service.PasswordEncryptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncryptionController {
    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final PasswordEncryptionService passwordEncryptionService;

    public EncryptionController(PasswordEncryptionService passwordEncryptionService) {
        this.passwordEncryptionService = passwordEncryptionService;
    }
    @GetMapping("/encryption")
    public String encryptionPage() {
        logger.info("controller = encryptionPage start");
        return "encrypt"; // HTML 템플릿 파일 이름
    }

    @PostMapping("/encrypt-passwords")
    public String encryptPasswords() {
        logger.info("controller = encryptPasswords start");
        passwordEncryptionService.encryptExistingPasswords();
        logger.info("controller = encryptPasswords end");
        return "redirect:/encryption"; // 프로세스 완료 후 다시 /encryption 페이지로 리다이렉트
    }
}