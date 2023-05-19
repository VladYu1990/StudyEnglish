package com.example.studyenglish;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressLint("StaticFieldLeak")
public
class GetURLData  extends AsyncTask<String, Void, String> {

    private JSONObject jsonObject;

    @SuppressLint("WrongThread")
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();

            connection.connect();


            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder buffer = new StringBuilder();
            String line = "";

            while((line = reader.readLine()) != null)
                buffer.append(line).append("\n");

            onPostExecute(buffer.toString());
            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Закрываем соединения, иначе получим лок и не сможем подключаться
            if(connection != null)
                connection.disconnect();

            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "error";
    }

    // Выполняется после завершения получения данных
    @SuppressLint("SetTextI18n")
    @Override
    protected void onPostExecute(String result) {
        try {
            jsonObject = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }
}




