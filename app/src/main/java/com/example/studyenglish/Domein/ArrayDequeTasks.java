package com.example.studyenglish.Domein;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Domein.Task;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class ArrayDequeTasks {

    public static ArrayDeque<Task> tasks;

    public static void  create(){tasks = new ArrayDeque<Task>();}

    public static int sizeArrayDequeTasks(){
        return ArrayDequeTasks.tasks.size();
    }

    public static void addTasks(ArrayList<Task> tasks){
        for(Task task:tasks) {
            ArrayDequeTasks.tasks.addLast(task);
        }
    }
}
