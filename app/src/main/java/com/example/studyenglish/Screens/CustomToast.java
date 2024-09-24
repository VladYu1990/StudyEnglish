package com.example.studyenglish.Screens;

import android.widget.Toast;

import com.example.studyenglish.Configuration;

public interface CustomToast {

    public default void viewToast(String textToast){
        Toast toast = Toast.makeText(Configuration.getCurrentActivity(), textToast ,Toast.LENGTH_LONG);
        toast.show();
    }
}
