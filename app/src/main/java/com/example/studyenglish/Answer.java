package com.example.studyenglish;

import android.widget.Button;

import java.lang.reflect.Array;

public class Answer {

    private int idSource;
    private Button button;
    private String value;
    private boolean correct;

    public Answer() {
    }

    public Answer(Button button) {
        this.button = button;
    }

    public Answer(int idSource, String value, boolean correct) {

        this.button = button;
        this.correct = correct;
    }


    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
        this.button.setText(value);
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
