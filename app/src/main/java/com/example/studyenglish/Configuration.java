package com.example.studyenglish;


import com.example.studyenglish.Domein.Token;
import com.example.studyenglish.Domein.User;
import com.example.studyenglish.Screens.MyScreen;

import kotlin.jvm.Synchronized;

public class Configuration {
    private final static String ip = "212.20.46.135";
    private final static String port = "8080";
    private final static String protokol = "http";
    private final static Integer countTasksDefault = 10;
    private static String version = "0.1";
    private static User user = new User();
    private static Token token = new Token();
    private final static int numberOfNetworkRequestAttempts = 5;
    private static MyScreen currentActivity;
    private static int minCountTasks = 5;
    private static int countAnswerForOneTask = 4;



    public static String getVersion() {
        return version;
    }

    public static String getBaseUrl() {
        return protokol+"://"+ip+":"+port+"/";
    }

    public static Integer getCountTasksDefault() {
        return countTasksDefault;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Configuration.user = user;
    }

    public static int getNumberOfNetworkRequestAttempts(User user) {return numberOfNetworkRequestAttempts;}

    public static Token getToken() {
        return token;
    }

    @Synchronized
    public static void setToken(Token token) {
        Configuration.token = token;
        System.out.println("токен обновлен");
    }

    public static MyScreen getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(MyScreen currentActivity) {
        Configuration.currentActivity = currentActivity;
    }

    public static int getMinCountTasks() {
        return minCountTasks;
    }

    public static int getCountAnswerForOneTask() {
        return countAnswerForOneTask;
    }
}
