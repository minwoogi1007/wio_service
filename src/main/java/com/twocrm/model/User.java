package com.twocrm.model;


import jakarta.persistence.*;

@Entity
@Table(name = "TEMP01")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "USERID")
    private String userId;
    @Column(name = "EMP_NAME")
    private String username;

    @Column(name = "PW")
    private String password;

    // Getters
    public String getId() {
        return id;
    }

    public String getUserId(){ return userId;}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}