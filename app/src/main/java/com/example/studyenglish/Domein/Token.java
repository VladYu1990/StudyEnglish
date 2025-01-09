package com.example.studyenglish.Domein;

import java.time.Instant;

public class Token {
    private String token = "dd65aa2c-a600-438b-b9ba-974f73decfb8";
    private Instant dateDeath = Instant.now().plusMillis(30*24*60*60*1000);

    public Token() {
    }

    public Token(String token, Instant dateDeath) {
        this.token = token;
        this.dateDeath = dateDeath;
    }

    public boolean isValidate(){

        return true;
        //todo

        /* if(this == null || Instant.now().isAfter(this.dateDeath) || this.token == null){
            System.out.println("не авторизован" + Instant.now().toString());
            return false;
        }
        else {
            System.out.println("авторизован" + Instant.now().toString());
            return true;
        }*/
    }

    public String getToken() {
        return token;
    }
}
