package com.example.studyenglish.Application;

import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

public class AuthorizationService {

    private TokenService tokenService;

    public AuthorizationService() {
        tokenService = new TokenService();}

    public void login(String login, String password){tokenService.logIn(login,password);}

    public void goToRegistration(){
        ScreenConductor.goToRegistration();
    }


}
