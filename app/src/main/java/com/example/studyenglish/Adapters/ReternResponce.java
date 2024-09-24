package com.example.studyenglish.Adapters;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.GetURLData;

public class ReternResponce {

    private String stringBaseURL = Configuration.getBaseUrl() + "/user_tasks/";


    public ReternResponce() {
    }


    public void sendResponse(int idUserTask, int id){
        String stringURL = stringBaseURL + idUserTask + "/response/" + id;

        GetURLData getURLData = new GetURLData();
        //getURLData.execute(stringURL);
    }
}
