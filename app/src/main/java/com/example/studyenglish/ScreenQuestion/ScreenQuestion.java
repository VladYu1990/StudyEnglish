package com.example.studyenglish.ScreenQuestion;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyenglish.Answer;
import com.example.studyenglish.R;
import com.example.studyenglish.ServisesWorkWithOutExternal.GetNextQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ScreenQuestion extends AppCompatActivity {
    public Button buttonAnswer1;
    public Button buttonAnswer2;
    public Button buttonAnswer3;
    public Button buttonAnswer4;
    public TextView textView;
    public Map<Integer, Answer> mapButton= new HashMap<Integer, Answer>();
    public ArrayList listCodesOfTrueAnswers = new ArrayList();
    public Answer answer11 = new Answer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAnswer1 = findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = findViewById(R.id.buttonAnswer4);
        textView = (TextView) findViewById(R.id.textView);

        refreshButton();

        mapButton.put(1,new Answer(buttonAnswer1));
        mapButton.put(2,new Answer(buttonAnswer2));
        mapButton.put(3,new Answer(buttonAnswer3));
        mapButton.put(4,new Answer(buttonAnswer4));


        getNextQuestion();
        refreshButton();

    }


    public void OnClickButtonAnswer1(View view){
        int i = 1;
        answerCheck(mapButton.get(i));
    }
    public void OnClickButtonAnswer2(View view){
        int i = 2;
        answerCheck(mapButton.get(i));
    }
    public void OnClickButtonAnswer3(View view){
        int i = 3;
        answerCheck(mapButton.get(i));
    }
    public void OnClickButtonAnswer4(View view){
        int i = 4;
        answerCheck(mapButton.get(i));
    }

    public void onClickButtonNextQuestion(View view){

        getNextQuestion();
        refreshButton();

    }

    private void answerCheck(Answer answer){
        if(answer.getCorrect()){
            answer.getButton().setBackgroundColor(Color.GREEN);
            //todo вызов метода возврата ответа на бэк(бэк сам решает верный или нет был ответ
        }
            else {
                for(int i = 0;i<mapButton.size();i++ ) {
                if (mapButton.get(i + 1).getCorrect()) {
                    mapButton.get(i + 1).getButton().setBackgroundColor(Color.GREEN);
                }
                    else mapButton.get(i + 1).getButton().setBackgroundColor(Color.RED);
            }
        }


    }



    private void getNextQuestion() {
        newRequestOnURL();

    }

    private void newRequestOnURL(){
        GetNextQuestion getNextQuestion = new GetNextQuestion(this);

    }


    public void setTextView(String text) {
        this.textView.setText(text);
    }

    public void refreshButton(){
        buttonAnswer1.setBackgroundColor(Color.GRAY);
        buttonAnswer2.setBackgroundColor(Color.GRAY);
        buttonAnswer3.setBackgroundColor(Color.GRAY);
        buttonAnswer4.setBackgroundColor(Color.GRAY);

    }


}
