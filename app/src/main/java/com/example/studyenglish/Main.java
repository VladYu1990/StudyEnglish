package com.example.studyenglish;


import android.os.Bundle;

import com.example.studyenglish.Flows.ThreadForCheckAuthorization;
import com.example.studyenglish.Flows.ThreadForTasks;
import com.example.studyenglish.Screens.MyScreen;
import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

public class Main extends MyScreen {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.setCurrentActivity(this);
        ScreenConductor.goToStart();

        Thread thread = new ThreadForCheckAuthorization();
        thread.start();

        Thread thread2 = new ThreadForTasks();
        //thread2.start();
    }

}

