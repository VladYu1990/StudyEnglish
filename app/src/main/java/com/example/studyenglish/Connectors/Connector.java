package com.example.studyenglish.Connectors;

import com.example.studyenglish.Configuration;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Connector {

    protected JSONObject jsonObject = null;
    protected int timeoutMillSec = 1000;
    protected String stringURLBase = Configuration.getBaseUrl();
    protected String stringURLReady = "";
    protected HttpURLConnection connection;
    protected Map<String, String> header = new HashMap<String,String>();
    protected String typeOfMethode;

    public Connector() {
    }

    public void executeRequest() {
        try {

            URL url = new URL(stringURLReady);
            connection = (HttpURLConnection) url.openConnection();
            System.out.println("connection with " + stringURLReady);

            for (Map.Entry<String, String> item : header.entrySet()) {
                connection.addRequestProperty(item.getKey(), item.getValue());
            }

            connection.setConnectTimeout(timeoutMillSec);
            connection.setRequestMethod(typeOfMethode);

            connection.setDoOutput(false);

            InputStream stream = connection.getInputStream();
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder buffer = new StringBuilder();
            String line = "";

            while((line = reader.readLine()) != null)
                buffer.append(line).append("\n");


            jsonObject = new JSONObject(buffer.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.disconnect();
        }
    }
}
