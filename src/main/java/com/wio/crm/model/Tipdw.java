package com.wio.crm.model;

public class Tipdw {
    private String id;
    private String pw;
    private String gubn;
    private String insertTime;
    private String confirmYn;
    private String confirmTime;
    private String confirmEmp;
    private String userId;
    private String username;

    // Getters and Setters
    // ID
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Password
    public String getPw() { return pw; }
    public void setPw(String pw) { this.pw = pw; }

    // ... (Other getters and setters)

    public String getGubn() {
        return gubn;
    }

    public void setGubn(String gubn) {
        this.gubn = gubn;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getConfirmYn() {
        return confirmYn;
    }

    public void setConfirmYn(String confirmYn) {
        this.confirmYn = confirmYn;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getConfirmEmp() {
        return confirmEmp;
    }

    public void setConfirmEmp(String confirmEmp) {
        this.confirmEmp = confirmEmp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
