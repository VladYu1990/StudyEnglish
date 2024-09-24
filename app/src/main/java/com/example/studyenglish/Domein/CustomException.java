package com.example.studyenglish.Domein;

public class CustomException extends Exception{
    private CustomExceptionType customExceptionType;
    private String message;


    public CustomException(CustomExceptionType customExceptionType){
        this.customExceptionType = customExceptionType;
        this.message = customExceptionType.getMessage();
    }

    public CustomExceptionType getCustomExceptionType() {
        return customExceptionType;
    }

    public String getMessage() {
        return message;
    }
}
