package com.example.studyenglish.Flows;

import android.os.AsyncTask;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.Connectors.Connector;

import org.json.JSONObject;

public class ThreadForRequest extends Thread {

    private Connector connector = null;


    public Connector getConnector() {
        return connector;
    }

    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void run() {
            connector.executeRequest();
    }

}
