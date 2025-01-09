package com.example.studyenglish.Connectors;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.Connector;
import com.example.studyenglish.Domein.Task;
import com.example.studyenglish.Domein.Token;

import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends Connector {

    private ArrayList<Task> tasks;


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
        stringURLReady = stringURLBase + "tasks/getNext/" +
                "?amountTasks=" + countTasks + "&amountAnswers=" + Configuration.getCountAnswerForOneTask();
    }

    private void extract() {

        try {
            JSONObject jsonResultObject = jsonObject.getJSONObject("result_object");
            String tokenStr = jsonResultObject.getString("task");
        } catch (Exception e) {
        }
    }
}



