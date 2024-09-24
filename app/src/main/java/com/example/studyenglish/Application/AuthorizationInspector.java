package com.example.studyenglish.Application;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Screens.AuthorizationMyScreen;
import com.example.studyenglish.Screens.RegistrationMyScreen;
import com.example.studyenglish.Screens.ScreenConductor.ScreenConductor;
import com.example.studyenglish.Screens.StartMyScreen;

public class AuthorizationInspector {


    public AuthorizationInspector() {
    }

    public void check(){
        if(isAuthorized()){
            if(Configuration.getCurrentActivity().getClass().equals(StartMyScreen.class)||
                    Configuration.getCurrentActivity().getClass().equals(AuthorizationMyScreen.class)||
                    Configuration.getCurrentActivity().getClass().equals(RegistrationMyScreen.class)){
                    ScreenConductor.goToTask();
                }
            }
            else {
                if(!Configuration.getCurrentActivity().getClass().equals(AuthorizationMyScreen.class) &
                        !Configuration.getCurrentActivity().getClass().equals(RegistrationMyScreen.class)){
                    ScreenConductor.goToAuthorization();
                }
            }
    }

    private boolean isAuthorized(){
        return Configuration.getToken().isValidate();
    }
}
