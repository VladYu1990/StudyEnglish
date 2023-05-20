package com.example.studyenglish.ServisesWorkWithOutExternal;

import com.example.studyenglish.GetURLData;
import com.example.studyenglish.ScreenQuestion.ScreenQuestion;

import org.json.JSONArray;
import org.json.JSONObject;

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
               this.screenQuestion.mapButton.get(i + 1).setIdSource(jsonArray.getJSONObject(i).getInt("id"));
               this.screenQuestion.mapButton.get(i + 1).setValue(jsonArray.getJSONObject(i).getString("value"));
               this.screenQuestion.mapButton.get(i + 1).setCorrect(jsonArray.getJSONObject(i).getBoolean("correct"));
           }
        }
        catch (Exception e) {
            this.screenQuestion.textView.setText("все сломалось \n уже работаем над исправление");
            //this.screenQuestion.buttonAnswer1.setText("нет данных");
            this.screenQuestion.buttonAnswer2.setText("нет данных");
            this.screenQuestion.buttonAnswer3.setText("нет данных");
            this.screenQuestion.buttonAnswer4.setText("нет данных");
        }
    }
}


