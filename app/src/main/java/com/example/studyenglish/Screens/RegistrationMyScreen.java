package com.example.studyenglish.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studyenglish.Application.RegistrationLogic;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.Domein.CustomException;
import com.example.studyenglish.R;

public class RegistrationMyScreen extends MyScreen {

    private Button buttonBack;
    private Button buttonRegistration;
    private TextView textViewLogin;
    private TextView textViewPassword;
    private TextView textViewPhone;
    private TextView textViewForErrors;
    private RegistrationLogic registrationLogic;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        registrationLogic = new RegistrationLogic();

        buttonBack = findViewById(R.id.buttonBack2);
        buttonRegistration = findViewById(R.id.buttonRegistrationNewUser);
        textViewLogin = findViewById(R.id.textViewNewLogin);
        textViewPassword = findViewById(R.id.textViewNewPassword);
        textViewPhone = findViewById(R.id.textViewPhone);

        buttonBack.setText("Назад");
        buttonRegistration.setText("Регистрация");
        textViewLogin.setText("login1");
        textViewPassword.setText("password1");
        textViewPhone.setText("8923456");

    }

    public void onClickButtonRegistration(View view){
        String loginStr = String.valueOf(textViewLogin.getText());
        String passwordStr = String.valueOf(textViewPassword.getText());
        String phoneStr = String.valueOf(textViewPhone.getText());

        //todo ошибки типа: не верно введено значение, юзер суш, нет интернета
            registrationLogic.registration(loginStr,passwordStr,phoneStr);
    }

    public void onClickButtonBack(View view){
        registrationLogic.onClickButtonBack();
    }

}
