package com.example.studyenglish.Application;

import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

public class LogicConductor{

    private ScreenConductor screenConductor;

    public LogicConductor() {
        //this.screenConductor = Configuration.getScreenConductor();
    }


    public void openTask(){
        TasksService tasksService = new TasksService();

    }

    public void openSettings(){

    }

    public void openRegistration(){

    }


    public void logOut(){}



}
