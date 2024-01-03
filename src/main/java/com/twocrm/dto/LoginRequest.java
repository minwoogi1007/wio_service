package com.twocrm.dto;

public class LoginRequest {
    private String userId;
    private String password;

    // 기본 생성자
    public LoginRequest() {
    }

    // getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
