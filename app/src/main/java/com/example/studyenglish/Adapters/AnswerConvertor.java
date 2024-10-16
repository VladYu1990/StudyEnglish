package com.example.studyenglish.Adapters;

import com.example.studyenglish.Domein.Answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.UUID;

public class AnswerConvertor {


    public static ArrayList<Answer> convert(JSONArray answersJSON) throws JSONException {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        for(int i=0;i<answersJSON.length();i++){
            JSONObject jsonObject = answersJSON.getJSONObject(i);
            answers.add(new Answer(
                    UUID.fromString(jsonObject.getString("code")),
                    jsonObject.getString("value"),
                    jsonObject.getBoolean("correct")));
        }
        return answers;
    }
}
