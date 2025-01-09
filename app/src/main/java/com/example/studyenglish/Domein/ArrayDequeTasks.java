package com.example.studyenglish.Domein;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ArrayDequeTasks {

    public static ArrayDeque<Exercise> exercises;

    public static void  create(){
        exercises = new ArrayDeque<Exercise>();}

    public static int sizeArrayDequeTasks(){
        return ArrayDequeTasks.exercises.size();
    }

    public static void addTasks(ArrayList<Exercise> exercises){
        for(Exercise exercise : exercises) {
            ArrayDequeTasks.exercises.addLast(exercise);
        }
    }
}
