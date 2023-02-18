package com.example.studyenglish;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button buttonAnswer1;
    Button buttonAnswer2;
    Button buttonAnswer3;
    Button buttonAnswer4;
    TextView textView;
    String url = "http://192.168.0.10:8080/NewTopic/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnClickButton6(View view) {
        textView = (TextView) findViewById(R.id.textView);

        textView.setText("Огонь");
    }

    public void OnClickButton7(View view) {
    }

    public void OnClickButtonNextQuestion(View view) throws InterruptedException {
        textView = (TextView) findViewById(R.id.textView);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        GetURLData GUD = new GetURLData();
                GUD.execute(url);
        TimeUnit.SECONDS.sleep(1);

        textView.setText(GUD.question);
        buttonAnswer1.setText(GUD.buttonAnswer1);
        buttonAnswer2.setText(GUD.buttonAnswer2);
        buttonAnswer3.setText(GUD.buttonAnswer3);
        buttonAnswer4.setText(GUD.buttonAnswer4);
    }
}

