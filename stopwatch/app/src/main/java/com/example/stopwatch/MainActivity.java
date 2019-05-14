package com.example.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean runner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState != null){
//            seconds = savedInstanceState.getInt("seconds");
//            runner = savedInstanceState.getBoolean("runner");
//        }
        runTime();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("runner", runner);
    }

    public void startStopwatch(View view){
        runner = true;
    }

    public void stopStopwatch(View view){
        runner = false;
    }

    public void restartStopwatch(View view){
        runner = false;
        seconds = 0;
    }

    private void runTime() {
        final TextView tv = findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                stopWatch(tv);
                handler.postDelayed(this, 100);
            }
        });

    }

    public void stopWatch(TextView textView){
        int hours = seconds / 3600;
        int minuts = (seconds % 3600) / 60;
        int secs = seconds%60;
        String time = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minuts, secs);
        textView.setText(time);
        if (runner){
            seconds++;
        }
    }
}
