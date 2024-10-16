package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.TaskAdapter;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.Dequeues;

public class TasksDequeService {

    public TasksDequeService() {
    }

   public void refillIfRequired(){
        if(Dequeues.exerciseArrayDeque.size()>Configuration.getMinCountTasks())
        {
            fill(10 - Dequeues.exerciseArrayDeque.size());
        }
   }

   public void fill(int i){
        TaskAdapter taskAdapter = new TaskAdapter();
        taskAdapter.fillDeque(i);
   }

}
