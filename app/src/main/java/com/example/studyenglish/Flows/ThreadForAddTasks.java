package com.example.studyenglish.Flows;

import com.example.studyenglish.Connectors.TaskAdapter;

import java.util.List;

public class ThreadForAddTasks extends Thread{

    List<String> strings;
    TaskAdapter taskAdapter;

    public ThreadForAddTasks(List<String> strings){
        this.strings = strings;
    }


    @Override
    public void run(){
        taskAdapter = new TaskAdapter();
        taskAdapter.createTasks(strings);

    }

}
