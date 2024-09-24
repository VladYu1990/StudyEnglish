package com.example.studyenglish.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studyenglish.Application.AddTasksService;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.R;

import java.util.ArrayList;
import java.util.List;

public class AddTasksMyScreen extends MyScreen {

    private Button buttonAdd;
    private Button buttonBack;
    private TextView text;
    private TextView textViewWord0;
    private TextView textViewWord1;
    private TextView textViewWord2;
    private TextView textViewWord3;
    private TextView textViewWord4;
    private AddTasksService serviceClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtasks);

        serviceClass = new AddTasksService();

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setText("добавить");
        buttonBack = findViewById(R.id.buttonBack2);
        buttonBack.setText("<-");
        text = findViewById(R.id.textWriteWord);
        text.setText("Введите слова");
        textViewWord0 = findViewById(R.id.textViewWord0);
        textViewWord1 = findViewById(R.id.textViewWord1);
        textViewWord2 = findViewById(R.id.textViewWord2);
        textViewWord3 = findViewById(R.id.textViewWord3);
        textViewWord4 = findViewById(R.id.textViewWord4);
    }

    public void onClickButtonAdd(View view){
        List<String> strings = new ArrayList<>();
        strings.add(String.valueOf(textViewWord0.getText()));
        strings.add(String.valueOf(textViewWord1.getText()));
        strings.add(String.valueOf(textViewWord2.getText()));
        strings.add(String.valueOf(textViewWord3.getText()));
        strings.add(String.valueOf(textViewWord4.getText()));

        serviceClass.onClickButtonAdd(strings);
    }

    public void onClickButtonBack2(View view){
        //todo реализовать возврат
    }

}
