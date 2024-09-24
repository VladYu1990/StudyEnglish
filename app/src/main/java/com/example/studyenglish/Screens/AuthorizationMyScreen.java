package com.example.studyenglish.Screens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studyenglish.Application.AuthorizationService;
import com.example.studyenglish.Configuration;
import com.example.studyenglish.R;
import com.example.studyenglish.UserParameters;

public class AuthorizationMyScreen extends MyScreen {

    private Button buttonEntrance;
    private Button buttonRegistration;
    private TextView text;
    private TextView textViewLogin;
    private TextView textViewPassword;
    private AuthorizationService serviceClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Configuration.setCurrentActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);

        serviceClass = new AuthorizationService();

        buttonEntrance = findViewById(R.id.buttonEntrance);
        buttonRegistration = findViewById(R.id.buttonRegistration);
        text = findViewById(R.id.text);
        textViewLogin = findViewById(R.id.textViewLogin);
        textViewPassword = findViewById(R.id.textViewPassword);
        serviceClass = new AuthorizationService();

        buttonEntrance.setText("Войти");
        buttonRegistration.setText("Регистрация");
        textViewLogin.setText(UserParameters.login);
        textViewPassword.setText(UserParameters.password);
    }

    public void onClickButtonEntrance(View view){
            String loginStr = String.valueOf(textViewLogin.getText());
            String passwordStr = String.valueOf(textViewPassword.getText());
            serviceClass.login(loginStr,passwordStr);
    }

    public void onClickButtonRegistration(View view){

        serviceClass.goToRegistration();
    }


}
