package com.example.studyenglish.Connectors;

import com.example.studyenglish.Domein.Exercise;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdapter extends Connector {

    private ArrayList<Exercise> exercises;


    public void createTasks(List<String> strings){
        typeOfMethode = "POST";
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("?words=<" + strings.get(0));
        for(int i = 1;i<strings.size();i++){
            stringBuilder.append("," + strings.get(i));
        }
        stringBuilder.append(">");

        stringURLReady = stringURLBase + "exercise/create/" + stringBuilder.toString();
    }

    public void fillDeque(int countTasks){
        typeOfMethode = "GET";
        stringURLReady = stringURLBase + "exercise/next/" + countTasks;
    }

    private void extract() {

        try {
            JSONObject jsonResultObject = jsonObject.getJSONObject("result_object");
            String tokenStr = jsonResultObject.getString("task");
        } catch (Exception e) {
        }
    }
}



