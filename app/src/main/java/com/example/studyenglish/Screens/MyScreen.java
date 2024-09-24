package com.example.studyenglish.Screens;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyenglish.Configuration;

public abstract class MyScreen extends AppCompatActivity {

    public void viewToast(String textToast){
        System.out.println("старт тост");
        Toast toast = Toast.makeText(this, textToast ,Toast.LENGTH_LONG);
        toast.show();
    }
}
