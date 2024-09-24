package com.example.studyenglish.Domein;

import android.widget.Button;

import java.lang.reflect.Array;

public class Answer {

    private String code;
    private String value;
    private boolean correct;

    public Answer(String code, String value, boolean correct) {
        this.code = code;
        this.value = value;
        this.correct = correct;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public boolean isCorrect() {
        return correct;
    }
}
