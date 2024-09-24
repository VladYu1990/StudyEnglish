package com.example.studyenglish;

import android.graphics.Color;

public class BaseColorsDependingOnTheme {
    private static int backgroundScreen = Color.BLACK;
    private static int backgroundButton = Color.GRAY;
    private static int backgroundButtonTrueAnswer = Color.GREEN;
    private static int backgroundButtonFalseAnswer = Color.RED;
    private static int textButton = Color.WHITE;
    private static int backgroundTextView = Color.BLACK;
    private static int textTextView = Color.WHITE;

    public static void goBlackTheme(){
        backgroundScreen = Color.BLACK;
        backgroundButton = Color.GRAY;
        textButton = Color.WHITE;
        backgroundTextView = Color.GRAY;
        textTextView = Color.WHITE;

    }
    public static void goWhiteTheme(){
        backgroundScreen = Color.WHITE;
        backgroundButton = Color.GRAY;
        textButton = Color.WHITE;
        backgroundTextView = Color.BLACK;
        textTextView = Color.WHITE;
    }
    public static void goDarkTheme(){

    }
    public static void goPurpleTheme(){

    }

    public static int getBackgroundScreen() {
        return backgroundScreen;
    }

    public static int getBackgroundButton() {
        return backgroundButton;
    }


    public static int getBackgroundButtonTrueAnswer() {
        return backgroundButtonTrueAnswer;
    }

    public static int getBackgroundButtonFalseAnswer() {
        return backgroundButtonFalseAnswer;
    }

    public static int getTextButton() {
        return textButton;
    }

    public static int getBackgroundTextView() {
        return backgroundTextView;
    }

    public static int getTextTextView() {
        return textTextView;
    }
}
