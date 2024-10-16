package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.TaskAdapter;
import com.example.studyenglish.Dequeues;
import com.example.studyenglish.Domein.Exercise;
import com.example.studyenglish.Flows.ThreadForConnection;

import java.util.ArrayDeque;
import java.util.List;

public class TasksService {

    private ArrayDeque<Exercise> exercises = Dequeues.exerciseArrayDeque;

    public TasksService() {
    }

    public Exercise getNext() {
        return exercises.pollFirst();
    }

    public void saveAnswer(int numberAnswer){
        //todo
    }

    public Integer getCountTaskForRepetition(){
        try
        {
            return exercises.size();
        }
        catch (Exception e){
            return 0;
        }
    }


    public void createTasks(List<String> strings) {
        TaskAdapter connector = new TaskAdapter();
        connector.createTasks(strings);

        ThreadForConnection thread = new ThreadForConnection(connector);
        thread.start();
    }
}
