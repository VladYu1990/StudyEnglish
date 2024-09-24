package com.example.studyenglish.Screens.ScreenConductor;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Screens.AddTasksMyScreen;
import com.example.studyenglish.Screens.AuthorizationMyScreen;
import com.example.studyenglish.Screens.ErrorMyScreen;
import com.example.studyenglish.Screens.OkMyScreen;
import com.example.studyenglish.Screens.RegistrationMyScreen;
import com.example.studyenglish.Screens.SettingsMyScreen;
import com.example.studyenglish.Screens.StartMyScreen;
import com.example.studyenglish.Screens.TaskMyScreen;

public class ScreenConductor {

    public static void viewToast(String message){
        Configuration.getCurrentActivity().viewToast(message);
    }

    public static void goToStart(){goToScreen(StartMyScreen.class);}

    public static void goToAuthorization(){goToScreen(AuthorizationMyScreen.class);}

    public static void goToRegistration() {goToScreen(RegistrationMyScreen.class);}

    public static void goToSettings() {goToScreen(SettingsMyScreen.class);}

    public static void goToTask(){
        goToScreen(TaskMyScreen.class);
    }
    public static void goToError(){goToScreen(ErrorMyScreen.class);}
    public static void goToOK(){goToScreen(OkMyScreen.class);}
    public static void goToAddTask(){goToScreen(AddTasksMyScreen.class);}

    private static void goToScreen(Class goToClass){
        AppCompatActivity currentActivity = Configuration.getCurrentActivity();
        Intent intent = new Intent(currentActivity,goToClass);
        currentActivity.startActivity(intent);
    }


}
