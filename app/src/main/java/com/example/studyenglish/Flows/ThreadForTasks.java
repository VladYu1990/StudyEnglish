package com.example.studyenglish.Flows;

import android.os.AsyncTask;

import com.example.studyenglish.Application.AnswersForReturnService;
import com.example.studyenglish.Application.TasksDequeService;
import com.example.studyenglish.Application.TasksService;
import com.example.studyenglish.Connectors.Connector;

import org.json.JSONObject;

public class ThreadForTasks extends Thread {

    public void run() {
        TasksDequeService tasksDequeService = new TasksDequeService();
        while (true) {
            tasksDequeService.refillIfRequired();
            try {
                Thread.sleep(1 * 6 * 1000);
            }
            catch (InterruptedException e){
            }
        }

    }

}
