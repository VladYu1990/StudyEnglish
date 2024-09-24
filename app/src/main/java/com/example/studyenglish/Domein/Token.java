package com.example.studyenglish.Domein;

import java.time.Instant;

public class Token {
    private String token = "";
    private Instant dateDeath = Instant.now();

    public Token() {
    }

    public Token(String token, Instant dateDeath) {
        this.token = token;
        this.dateDeath = dateDeath;
    }

    public boolean isValidate(){

        if(this == null || Instant.now().isAfter(this.dateDeath) || this.token == null){
            System.out.println("не авторизован" + Instant.now().toString());
            return false;
        }
        else {
            System.out.println("авторизован" + Instant.now().toString());
            return true;
        }
    }

    public String getToken() {
        return token;
    }
}
