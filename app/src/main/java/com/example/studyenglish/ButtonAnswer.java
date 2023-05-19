package com.example.studyenglish;

import android.widget.Button;

import java.lang.reflect.Array;

public class ButtonAnswer {

    private int numberAnswer;
    private Button button;
    private boolean correct;

    public ButtonAnswer(int numberAnswer, Button button, boolean correct) {
        this.numberAnswer = numberAnswer;
        this.button = button;
        this.correct = correct;
    }

    public ButtonAnswer(Array array) {
        this.numberAnswer = numberAnswer;
        this.button = button;
        this.correct = correct;
    }
}
