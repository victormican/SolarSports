package com.example.solarsports.models;

public class UserSession {
    private static UserSession instance;

    private String username;
    private String email;
    private String phoneNumber;

    private String password;
    private String password2;

    private String name;

    public UserSession(String username, String email, String phoneNumber, String password, String password2, String name) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.password2 = password2;
        this.name = name;
    }



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



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


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
    public void clearSession() {
        username = null;
        email = null;
        phoneNumber = null;
        password = null;
        password2 = null;
        name = null;
    }
    public void logout() {
        clearSession();
    }
}