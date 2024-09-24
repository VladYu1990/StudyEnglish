package com.example.studyenglish.Screens;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyenglish.Application.TasksService;
import com.example.studyenglish.BaseColorsDependingOnTheme;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.Domein.Task;
import com.example.studyenglish.R;
import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

import java.util.ArrayList;
import java.util.Map;


public class TaskMyScreen extends MyScreen {
    private LinearLayout backGroundTaskScreen;
    private Button buttonSettings;
    private Button buttonAdd;
    private Button buttonScore;
    private TextView textView;
    private Button buttonAnswerLeftTop;
    private Button buttonAnswerRightTop;
    private Button buttonAnswerLeftDown;
    private Button buttonAnswerRightDown;
    private Button buttonNextTask;
    private ArrayList<Button> buttonsAnswers = new ArrayList<Button>();

    private boolean answerWasTake = false;
    private TasksService service;
    private Task task;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taskscreen);

        this.backGroundTaskScreen = findViewById(R.id.BackGroundTaskScreen);
        this.textView = findViewById(R.id.textView);
        this.buttonSettings = findViewById(R.id.buttonSettings);
        this.buttonScore = findViewById(R.id.buttonScore);
        this.buttonAdd = findViewById(R.id.buttonAddTask);

        this.buttonAnswerLeftTop = findViewById(R.id.buttonAnswer0);
        this.buttonAnswerRightTop = findViewById(R.id.buttonAnswer1);
        this.buttonAnswerLeftDown = findViewById(R.id.buttonAnswer2);
        this.buttonAnswerRightDown = findViewById(R.id.buttonAnswer3);
        this.buttonNextTask = findViewById(R.id.buttonNext);

        buttonsAnswers.add(buttonAnswerLeftTop);
        buttonsAnswers.add(buttonAnswerRightTop);
        buttonsAnswers.add(buttonAnswerLeftDown);
        buttonsAnswers.add(buttonAnswerRightDown);

        service = new TasksService();

        doForNextTask();
    }

    private void doForNextTask() {
        refreshBackgrounds();
       try {
           task = service.getNext();
           if (task == null){
               new Exception();
           }
           fill();
       }
       catch (Exception e){
           fillIfError();
       }

    }

    private void fill() {
        buttonNextTask.setText("Next");
        textView.setText(task.getQuestion());
        buttonAnswerLeftTop.setText(task.getAnswers().get(0).getValue());
        buttonAnswerRightTop.setText(task.getAnswers().get(1).getValue());
        buttonAnswerLeftDown.setText(task.getAnswers().get(2).getValue());
        buttonAnswerRightDown.setText(task.getAnswers().get(3).getValue());
    }

    private void fillIfError() {
        buttonNextTask.setText("Refresh");
        textView.setText("Все пошло не по тому пути. Знаем и ищем решение");
        buttonAnswerLeftTop.setText("боль");
        buttonAnswerRightTop.setText("печаль");
        buttonAnswerLeftDown.setText("уныние");
        buttonAnswerRightDown.setText("да пофиг");
    }


    private void refreshBackgrounds(){
        answerWasTake = false;
        backGroundTaskScreen.setBackgroundColor(BaseColorsDependingOnTheme.getBackgroundScreen());
        textView.setTextColor(BaseColorsDependingOnTheme.getTextTextView());
        buttonScore.setText(service.getCountTaskForRepetition().toString());
        for (int i = 0; i<buttonsAnswers.size(); i++) {
            buttonsAnswers.get(i).setBackgroundColor(BaseColorsDependingOnTheme.getBackgroundButton());
            buttonsAnswers.get(i).setTextColor(BaseColorsDependingOnTheme.getTextButton());
        }
    }

    public void OnClickButtonAnswer0(View view){
        checkClickOnAnswer(0);
    }
    public void OnClickButtonAnswer1(View view){
        checkClickOnAnswer(1);
    }
    public void OnClickButtonAnswer2(View view){
        checkClickOnAnswer(2);
    }
    public void OnClickButtonAnswer3(View view){
        checkClickOnAnswer(3);
    }

    private void checkClickOnAnswer(int i){
        if(!answerWasTake){
            answerWasTake = true;
            checkAnswer(i);
        }
    }

    private void checkAnswer(int i){
        if(task == null){
            return;
        }

        try {
            buttonsAnswers.get(i).setBackgroundColor(Color.RED);
            int numberTryAnswer = task.getNumberTryAnswer();
            buttonsAnswers.get(numberTryAnswer).setBackgroundColor(Color.GREEN);
            service.saveAnswer(i);
        }
        catch (Exception e){
            viewToast("ошибка. сообщите разработчикам, указав текст задания");
        }

    }

    public void onClickButtonNextQuestion(View view){
        if(answerWasTake){
            doForNextTask();
        }
    }

    public void OnClickButtonSettings(View view){
        //todo
        ScreenConductor.goToSettings();
    }

    public void OnClickButtonAddTask(View view){
        //todo
        ScreenConductor.goToAddTask();
    }

}
