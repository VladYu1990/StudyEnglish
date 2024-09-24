package com.example.studyenglish.Connectors;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Domein.Token;

import org.json.JSONObject;

import java.time.Instant;

public class UserAdapter extends Connector {

    public void create(String login, String password,String phone) {
        try {
            typeOfMethode = "POST";
            header.put("login", login);
            header.put("password", password);
            header.put("phone",phone);
            stringURLReady = stringURLBase + "users/create/";
        }
        catch (Exception e){}
    }
}
