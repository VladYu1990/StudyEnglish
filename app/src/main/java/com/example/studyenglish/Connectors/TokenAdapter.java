package com.example.studyenglish.Connectors;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.Connector;
import com.example.studyenglish.Domein.Token;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.time.Instant;

public class TokenAdapter extends Connector {

    public void login(String login, String password) {
        try {
            typeOfMethode = "PUT";
            header.put("login", login);
            header.put("password", password);
            stringURLReady = stringURLBase + "users/logIn";
        }
        catch (Exception e){}
    }


    public Token extract() throws Exception{
            Thread.sleep(1000);
            System.out.println(jsonObject.toString());
            String tokenStr = jsonObject.getString("uuid");
            String instantString = jsonObject.getString("dateOfDeathToken");

            return new Token(tokenStr, Instant.parse(instantString));
    }

}
