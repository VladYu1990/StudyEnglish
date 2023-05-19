package com.example.studyenglish.ScreenQuestion;

import static android.net.wifi.WifiConfiguration.Status.strings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyenglish.ButtonAnswer;
import com.example.studyenglish.GetURLData;
import com.example.studyenglish.R;
import com.example.studyenglish.ServisesWorkWithOutExternal.GetNextQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ScreenQuestion extends AppCompatActivity {
    public Button buttonAnswer1;
    public Button buttonAnswer2;
    public Button buttonAnswer3;
    public Button buttonAnswer4;
    public TextView textView;
    public ArrayList listCodesOfTrueAnswers = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonAnswer1 = findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = findViewById(R.id.buttonAnswer4);
        textView = (TextView) findViewById(R.id.textView);

        getNextQuestion();
        refreshButton();

    }


    public void OnClickButtonAnswer1(View view){
        questionCheck(1,buttonAnswer1);
    }
    public void OnClickButtonAnswer2(View view){
        questionCheck(2,buttonAnswer2);
    }
    public void OnClickButtonAnswer3(View view){
        questionCheck(3,buttonAnswer3);
    }
    public void OnClickButtonAnswer4(View view){
        buttonAnswer4.setBackgroundColor(Color.BLUE);
        questionCheck(4,buttonAnswer4);
    }

    public void onClickButtonNextQuestion(View view){

        getNextQuestion();

    }

    private void questionCheck(int number,Button button){
       //TODO

    }



    private void getNextQuestion() {
        newRequestOnURL();

    }

    private void newRequestOnURL(){
        buttonAnswer3.setText("newRequestOnURL");
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
