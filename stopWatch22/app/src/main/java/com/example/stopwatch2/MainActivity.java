package com.example.stopwatch2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int seconds = 0;
    boolean runner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();

    }

    public void startStopWatch(View view){
        runner = true;
    }

    public void stopStopWatch(View view){
        runner = false;
    }

    public void resetStopWatch(View view){
        runner = false;
        seconds = 0;
    }

    void stopWatch(TextView textView){
        int hours = seconds / 3600;
        int minuts = (seconds % 3600) / 60;
        int secs = seconds%60;
        String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minuts, secs);
        textView.setText(time);
        if (runner){
            seconds++;
        }
    }

    void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                TextView textView = findViewById(R.id.textView);
                stopWatch(textView);
                handler.postDelayed(this, 10);
            }
        });
    }
}
