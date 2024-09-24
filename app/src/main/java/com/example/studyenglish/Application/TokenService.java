package com.example.studyenglish.Application;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.TokenAdapter;
import com.example.studyenglish.Domein.Token;
import com.example.studyenglish.Flows.ThreadForConnection;

public class TokenService {

    private Token token;

    public TokenService() {
    }

    public void logIn(String login,String password){

        TokenAdapter connector = new TokenAdapter();
        connector.login(login,password);

        ThreadForConnection thread = new ThreadForConnection(connector);
        thread.start();

        try {
            token = connector.extract();
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save(){
        Configuration.setToken(token);
    }
}
