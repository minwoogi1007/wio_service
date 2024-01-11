package com.wio.crm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptExistingPasswordsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository; // UserRepository는 데이터베이스와의 상호작용을 담당

    public void encryptPasswords() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            String encryptedPassword = passwordEncoder.encode(user.getPw());
            user.setPw(encryptedPassword);
            userRepository.save(user);
        }
    }
}
