package com.example.huriyah.mobilehci;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class Timer extends AppCompatActivity {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean operational;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);

    }

    public void startChronometer(View v) {
        if (!operational) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            operational = true;
        }
    }

    public void stopChronometer(View v) {
        if (operational) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            operational = false;
        }
    }

    public void clearChronometer(View v) {
        if (!operational) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }
    /*
    public void onClick(View view){
        if(view == b){

            Intent intent = new Intent(Timer.this, Timer.class);
            startActivity(intent);
        }

    } */
}
