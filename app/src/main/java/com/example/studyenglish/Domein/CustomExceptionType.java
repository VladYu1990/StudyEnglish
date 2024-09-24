package com.example.studyenglish.Domein;

public enum CustomExceptionType {
    EXCEPTION_AUTHORIZATION("не верный логин и/или пароль"),
    EXCEPTION_TOKEN("токен не валиден, требуется переавторизация"),
    EXCEPTION_NETWORK("нет интернета, проверьте интернет и повторите");

    private String message;

    CustomExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

