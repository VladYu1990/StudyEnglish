package com.example.studyenglish;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyenglish.ScreenQuestion.ScreenQuestion;

public class Main extends AppCompatActivity{




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        goTo(ScreenQuestion.class);

    }


    public void goTo(Class goToClass){
        Intent intent = new Intent(this,goToClass);
        startActivity(intent);
    }
}

