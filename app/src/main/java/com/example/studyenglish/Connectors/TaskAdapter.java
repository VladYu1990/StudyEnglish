package com.example.studyenglish.Connectors;

import com.example.studyenglish.Adapters.AnswerConvertor;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.Dequeues;
import com.example.studyenglish.Domein.Answer;
import com.example.studyenglish.Domein.Exercise;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TaskAdapter extends Connector {

    private ArrayList<Exercise> exercises;


    public void createTasks(List<String> strings){
        typeOfMethode = "POST";
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("?words=<" + strings.get(0));
        for(int i = 1;i<strings.size();i++){
            stringBuilder.append("," + strings.get(i));
        }
        stringBuilder.append(">");

        stringURLReady = stringURLBase + "tasks/create/" + stringBuilder.toString();
    }

    public void fillDeque(int countTasks){
        typeOfMethode = "GET";
        stringURLReady = stringURLBase + "exercise/next/" + Configuration.getCountAnswerForOneTask();
    }

    private void extract() {

        try {
            Iterator x = jsonObject.keys();

            while(x.hasNext()) {
                JSONObject jsonObjectEx = (JSONObject) x.next();
                //создать упражнение
                //создать набор ответов
                ArrayList<Answer> answers = AnswerConvertor.convert(jsonObjectEx.getJSONArray("answerOptions"));
                Exercise exercise = new Exercise(
                        UUID.fromString(jsonObjectEx.getString("uuid")),
                        jsonObjectEx.getString("question"),
                        answers);
                Dequeues.exerciseArrayDeque.add(exercise);
            }
            } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }
}



