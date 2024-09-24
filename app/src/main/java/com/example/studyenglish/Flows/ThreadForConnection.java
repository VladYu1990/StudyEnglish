package com.example.studyenglish.Flows;

import com.example.studyenglish.Connectors.Connector;
import com.example.studyenglish.Connectors.TokenAdapter;

public class ThreadForConnection extends Thread{

    private Connector connector;

    public ThreadForConnection(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void run(){
        connector.executeRequest();
    }

}
