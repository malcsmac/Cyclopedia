package com.example.huriyah.mobilehci;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button timerButton;
    private Button clubButton;

    TextView t;
    Handler h = new Handler();

    private static DecimalFormat df2 = new DecimalFormat(".##");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerButton = (Button) findViewById(R.id.timer);
        clubButton = (Button) findViewById(R.id.clubs);

        timerButton.setOnClickListener(this);
        clubButton.setOnClickListener(this);

        t = (TextView) findViewById(R.id.view);



        Runnable r = new Runnable() {
            int count = 0;


            @Override
            public void run() {
                    count++;
                    if (count < 34) {
                        if (count / 2 == 0) {
                            t.setText("" + count * 1.8 + " mph");
                        } else {
                            t.setText("" + df2.format(count / 1.2) + " mph");
                        }
                    }
                    else{
                        t.setText("> 30mph \n SLOW DOWN!");
                    }
                    h.postDelayed(this, 1000); //ms
                }

        };

        h.post(r);




    }

    public void onClick(View view){
        if(view == timerButton){
            Intent intent = new Intent(MainActivity.this, Languages.class);
            startActivity(intent);
        }
        if(view == clubButton){
            Intent intent = new Intent(MainActivity.this, CyclingClubs.class);
            startActivity(intent);
        }

    }


}











































































































































































































































































































































































































































