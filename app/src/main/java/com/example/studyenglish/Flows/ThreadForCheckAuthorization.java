package com.example.studyenglish.Flows;

import com.example.studyenglish.Application.AuthorizationInspector;

import java.time.Instant;

public class ThreadForCheckAuthorization extends Thread {

    private AuthorizationInspector authorizationInspector = new AuthorizationInspector();


    public void run() {
        while (true) {
            authorizationInspector.check();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}


        }
    }
}


