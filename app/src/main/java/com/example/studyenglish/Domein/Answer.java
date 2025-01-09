package com.example.studyenglish.Domein;

import android.widget.Button;

import java.lang.reflect.Array;
import java.util.UUID;

public class Answer {

    private UUID code;
    private String value;
    private boolean correct;

    public Answer(UUID code, String value, boolean correct) {
        this.code = code;
        this.value = value;
        this.correct = correct;
    }

    public UUID getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public boolean isCorrect() {
        return correct;
    }
}
