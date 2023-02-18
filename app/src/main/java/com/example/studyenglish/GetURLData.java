package com.example.studyenglish;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

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
class GetURLData extends AsyncTask<String, String, String> {
    public String question = "hhh";
    public String buttonAnswer1 = "не успели получить";
    public String buttonAnswer2 = "не успели получить";
    public String buttonAnswer3 = "не успели получить";
    public String buttonAnswer4 = "не успели получить";
    public int numberTrueAnswer = 0;


    // Будет выполняться во время подключения по URL
    //@Override
    @SuppressLint("WrongThread")
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Создаем URL подключение, а также HTTP подключение
            Log.i("Print", "2");
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            Log.i("Print", "2.1");
            connection.connect();
            Log.i("Print", "3");

            // Создаем объекты для считывания данных из файла
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            // Генерируемая строка
            StringBuilder buffer = new StringBuilder();
            String line = "";

            // Считываем файл и записываем все в строку
            while((line = reader.readLine()) != null)
                buffer.append(line).append("\n");

            // Возвращаем строку


            onPostExecute(buffer.toString());
            return buffer.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Закрываем соединения
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
        super.onPostExecute(result);

        // Конвертируем JSON формат и выводим данные в текстовом поле
        try {
            JSONObject jsonObject = new JSONObject(result);
            question = jsonObject.getJSONObject("question").getString("value");
            buttonAnswer1 = jsonObject.getJSONObject("listAnswers").getJSONObject("answer1").getString("value");
            buttonAnswer2 = jsonObject.getJSONObject("listAnswers").getJSONObject("answer2").getString("value");
            buttonAnswer3 = jsonObject.getJSONObject("listAnswers").getJSONObject("answer3").getString("value");
            buttonAnswer4 = jsonObject.getJSONObject("listAnswers").getJSONObject("answer4").getString("value");


            numberTrueAnswer = jsonObject.getJSONObject("listAnswers").getInt("numberTrueAnswer");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}



