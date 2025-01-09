package com.example.studyenglish.Application;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.TaskAdapter;
import com.example.studyenglish.Dequeues;
import com.example.studyenglish.Domein.Answer;
import com.example.studyenglish.Domein.Task;
import com.example.studyenglish.Flows.ThreadForConnection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TasksService {

    private ArrayDeque<Task> tasks = Dequeues.taskArrayDeque;

    public TasksService() {
    }

    public Task getNext() {
        return tasks.pollFirst();
    }

    public void saveAnswer(int numberAnswer){
        //todo
    }

    public Integer getCountTaskForRepetition(){
        try
        {
            return tasks.size();
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
