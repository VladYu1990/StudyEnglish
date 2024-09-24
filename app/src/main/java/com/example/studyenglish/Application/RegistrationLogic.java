package com.example.studyenglish.Application;

import com.example.studyenglish.Domein.CustomException;
import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;

public class RegistrationLogic {

    private TokenService tokenService;
    private UserService userService;

    public RegistrationLogic() {

        tokenService = new TokenService();
        userService = new UserService();
    }

    public void registration(String login,String password, String phone){
        userService.create(login,password,phone);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tokenService.logIn(login,password);
        //на экран тасок перекинет автоматом проверка авторизации, которая работает в другом потоке

    }


    public void onClickButtonBack(){
        ScreenConductor screenConductor = new ScreenConductor();
        screenConductor.goToAuthorization();
    }
}
