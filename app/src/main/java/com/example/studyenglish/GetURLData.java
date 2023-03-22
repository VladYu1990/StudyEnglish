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
import java.util.Arrays;
import java.util.List;

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
            numberTrueAnswer = jsonObject.getJSONObject("listAnswers").getInt("number") + 1;
            question = jsonObject.getString("writingObject");
            String listString = jsonObject.getJSONObject("listAnswers").getString("list")
                    .replace("\"","")
                    .replace("[","")
                    .replace("]","");
            List<String> list = Arrays.asList(listString.split("\\s*,\\s*"));
            buttonAnswer1 = list.get(0);
            buttonAnswer2 = list.get(1);
            buttonAnswer3 = list.get(2);
            buttonAnswer4 = list.get(3);





        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}



