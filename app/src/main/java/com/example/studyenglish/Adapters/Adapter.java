package com.example.studyenglish.Adapters;

import com.example.studyenglish.Connectors.Connector;
import com.example.studyenglish.Domein.Token;
import com.example.studyenglish.Flows.ThreadForRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;

public abstract class Adapter {

    protected Connector connector = new Connector();

    public Adapter() {
    }


    public void startThread(){
        ThreadForRequest thread = new ThreadForRequest();
        thread.setConnector(this.connector);
        thread.start();
        System.out.println("поток запроса запушен");
    }

}
