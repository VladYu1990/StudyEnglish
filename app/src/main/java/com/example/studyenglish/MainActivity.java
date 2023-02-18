package com.example.studyenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button buttonAnswer1;
    Button buttonAnswer2;
    Button buttonAnswer3;
    Button buttonAnswer4;
    TextView textView;
    String url = "http://192.168.0.10:8080/NewTopic/1";
    GetURLData GUD = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            getNextQuestion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void OnClickButtonAnswer1(View view){
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        questionCheck(1,buttonAnswer1);
    }
    public void OnClickButtonAnswer2(View view){
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        questionCheck(2,buttonAnswer2);
    }
    public void OnClickButtonAnswer3(View view){
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        questionCheck(3,buttonAnswer3);
    }
    public void OnClickButtonAnswer4(View view){
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);
        questionCheck(4,buttonAnswer4);
    }



    public void onClickButtonNextQuestion(View view) throws InterruptedException {
        getNextQuestion();

    }

    private void questionCheck(int number,Button button){
        if (GUD.numberTrueAnswer == number){
            button.setBackgroundColor(Color.GREEN);//hex true

        } else {
            button.setBackgroundColor(Color.RED);//hex false
        };


    }



    private void getNextQuestion() throws InterruptedException {

            newRequestOnURL();


            //добавить сброс цвета кнопок
            textView = (TextView) findViewById(R.id.textView);
            buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
            buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
            buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
            buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);


            TimeUnit.SECONDS.sleep(1);

            textView.setText(GUD.question);
            buttonAnswer1.setText(GUD.buttonAnswer1);
            buttonAnswer2.setText(GUD.buttonAnswer2);
            buttonAnswer3.setText(GUD.buttonAnswer3);
            buttonAnswer4.setText(GUD.buttonAnswer4);

    }

    private void newRequestOnURL(){
        GUD = new GetURLData();
        GUD.execute(url);
    }


}

