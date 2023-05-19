package com.example.studyenglish.ServisesWorkWithOutExternal;

import android.util.Log;

import com.example.studyenglish.GetURLData;
import com.example.studyenglish.ScreenQuestion.ScreenQuestion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GetNextQuestion {

    private ScreenQuestion screenQuestion;
    private String userToken = "123";
    private String stringURL = "http://192.168.0.10:8080/v1/next_user_task/"+ userToken +"/";


    private JSONObject jsonObject;

    public GetNextQuestion(ScreenQuestion screenQuestion){
        this.screenQuestion = screenQuestion;

        getData();
        fillScreenQuestion();
    }

    private void getData()  {
        GetURLData getURLData = new GetURLData();
        getURLData.execute(stringURL);

        try {
            Thread.sleep(250);//без этого говна не работает,
            //похоже инстанс не успевает в рантайме получить данные и ему нужно на это время
            jsonObject = getURLData.getJsonObject();
        } catch (Exception e) {}
    }

    private void fillScreenQuestion() {


        try {

            this.screenQuestion.textView.setText(jsonObject.getString("question"));

            JSONArray jsonArray = jsonObject.getJSONArray("listAnswers");

           for(int  i=0;i<jsonArray.length();i++) {
               if (jsonArray.getJSONObject(i).getBoolean("correct")) {
                   int code = jsonArray.getJSONObject(i).getInt("id");
                   this.screenQuestion.listCodesOfTrueAnswers.add(code);
               }

           }

            this.screenQuestion.buttonAnswer1.setText(jsonArray.getJSONObject(0).getString("value"));
            this.screenQuestion.buttonAnswer2.setText(jsonArray.getJSONObject(0).getString("value"));
            this.screenQuestion.buttonAnswer3.setText(jsonArray.getJSONObject(0).getString("value"));
            this.screenQuestion.buttonAnswer4.setText(jsonArray.getJSONObject(0).getString("value"));
        }
        catch (Exception e) {
            this.screenQuestion.textView.setText("все сломалось \n уже работаем над исправление");
            this.screenQuestion.buttonAnswer1.setText("нет данных");
            this.screenQuestion.buttonAnswer2.setText("нет данных");
            this.screenQuestion.buttonAnswer3.setText("нет данных");
            this.screenQuestion.buttonAnswer4.setText("нет данных");
        }
    }
}


