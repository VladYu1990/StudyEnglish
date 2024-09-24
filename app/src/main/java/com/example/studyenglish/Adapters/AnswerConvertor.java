package com.example.studyenglish.Adapters;

import com.example.studyenglish.Domein.Answer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnswerConvertor {


    public static ArrayList<Answer> convert(JSONArray answersJSON) throws JSONException {
        ArrayList<Answer> answers = new ArrayList<Answer>();
        for(int i=0;i<answersJSON.length();i++){
            JSONObject jsonObject = answersJSON.getJSONObject(i);
            answers.add(new Answer(
                    jsonObject.getString("code"),
                    jsonObject.getString("value"),
                    jsonObject.getBoolean("correct")));
        }
        return answers;
    }
}
