package com.example.solarsports.models;

public class UserSession {
    private static UserSession instance;

    public UserSession(String username) {
        this.username = username;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String username;
    private String email;
    private String phoneNumber;
    public UserSession(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    private UserSession() {
        // Constructor privado para evitar instanciación directa
    }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setUser(String username, String email, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


}