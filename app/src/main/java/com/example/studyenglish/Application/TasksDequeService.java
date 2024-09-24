package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.TaskAdapter;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.Dequeues;

public class TasksDequeService {

    public TasksDequeService() {
    }

   public void refillIfRequired(){
        if(Dequeues.taskArrayDeque.size()>Configuration.getMinCountTasks())
        {
            fill(10 - Dequeues.taskArrayDeque.size());
        }
   }

   public void fill(int i){
        TaskAdapter taskAdapter = new TaskAdapter();
        taskAdapter.fillDeque(i);
   }

}
