package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.TaskAdapter;
import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

import java.util.List;

public class AddTasksService {

    public AddTasksService() {
    }

    public void onClickButtonAdd(List<String> strings){
        //todo by tasksService
        TasksService tasksService = new TasksService();
        tasksService.createTasks(strings);

    }

    public void onClickButtonBack2(){
        ScreenConductor.goToTask();}






}
