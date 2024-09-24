package com.example.studyenglish.Screens;

import android.os.Bundle;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.R;

public class OkMyScreen extends MyScreen {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok);

    }
}
