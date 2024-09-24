package com.example.studyenglish.Connectors;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.example.studyenglish.Configuration;
import com.example.studyenglish.UserParameters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

import javax.xml.transform.Result;

@SuppressLint("StaticFieldLeak")
public class GetURLData{

    private JSONObject jsonObject = null;


    public void goToUrl(String stringPartOfUrl, String typeMethode, Instant instant){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder buffer = new StringBuilder();

        try {
            URL url = new URL(Configuration.getBaseUrl() + stringPartOfUrl + "?time=" + instant.toString());
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("token", UserParameters.token);
            connection.setRequestProperty("student_code",UserParameters.code);
            connection.setConnectTimeout(5000 /* milliseconds */);
            connection.setRequestMethod( typeMethode );

            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            reader = new BufferedReader(inputStreamReader);

            String line = "";

            while((line = reader.readLine()) != null)
                buffer.append(line).append("\n");

            jsonObject = new JSONObject(buffer.toString());

        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        finally {
            connection.disconnect();
            try {
                reader.close();
            }
            catch (Exception e){}
        }
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}




