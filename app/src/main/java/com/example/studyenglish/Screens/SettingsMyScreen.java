package com.example.studyenglish.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.studyenglish.BaseColorsDependingOnTheme;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.R;

public class SettingsMyScreen extends MyScreen {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }

    public void OnClickButtonBack(View view){goTo(TaskMyScreen.class);}

    public void goTo(Class goToClass){
        Intent intent = new Intent(this,goToClass);
        startActivity(intent);
    }

    public void OnClickButtonWhite(View view){
        BaseColorsDependingOnTheme.goWhiteTheme();
    }

    public void OnClickButtonBlack(View view){
        BaseColorsDependingOnTheme.goBlackTheme();
    }


}
