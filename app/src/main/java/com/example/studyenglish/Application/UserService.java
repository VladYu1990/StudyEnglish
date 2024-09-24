package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.UserAdapter;
import com.example.studyenglish.Flows.ThreadForConnection;

public class UserService {

    public UserService() {
    }

    public void create(String login, String password, String phone) {
        UserAdapter connector = new UserAdapter();
        connector.create(login,password,phone);
        ThreadForConnection thread = new ThreadForConnection(connector);
        thread.start();
    }
}
