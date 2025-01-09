package com.example.studyenglish.Flows;

import com.example.studyenglish.Connectors.ExerciseAdapter;

import java.util.List;

public class ThreadForAddTasks extends Thread{

    List<String> strings;
    ExerciseAdapter exerciseAdapter;

    public ThreadForAddTasks(List<String> strings){
        this.strings = strings;
    }


    @Override
    public void run(){
        exerciseAdapter = new ExerciseAdapter();
        exerciseAdapter.createTasks(strings);

    }

}
