package com.example.studyenglish.Domein;

public class User {
    private String login = "vladimirYu";
    private String phone = "5240";

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
