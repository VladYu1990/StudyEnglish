package com.example.studyenglish.Domein;

public class User {
    private String login = "";
    private String phone = "";

    public User(){}

    public User(String login,String phone) {
        this.login = login;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPhone() {
        return phone;
    }
}
