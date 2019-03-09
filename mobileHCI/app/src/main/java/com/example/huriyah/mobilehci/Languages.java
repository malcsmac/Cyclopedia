package com.example.huriyah.mobilehci;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Languages extends AppCompatActivity {

    Button languagesButton;
    Dialog myDialog;
    Button englishButton, frenchButton;
    ImageView ukButton, franceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        myCustomDialog();
        languagesButton = (Button) findViewById(R.id.language);
        languagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCustomDialog();

            }
        });
    }

    public void myCustomDialog(){
        myDialog = new Dialog(Languages.this);
        myDialog.setContentView(R.layout.custom_dialog);
        myDialog.setTitle("Select your language");

        englishButton = (Button)myDialog.findViewById(R.id.english);
        frenchButton = (Button)myDialog.findViewById(R.id.french);
        ukButton = (ImageView) myDialog.findViewById(R.id.uk);
        franceButton = (ImageView)myDialog.findViewById(R.id.france);

        englishButton.setEnabled(true);
        frenchButton.setEnabled(true);
        ukButton.setEnabled(true);
        franceButton.setEnabled(true);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                startActivity(intent);

            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HomepageFrench.class);
                startActivity(intent);

            }
        });

        ukButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Homepage.class);
                startActivity(intent);

            }
        });

        franceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HomepageFrench.class);
                startActivity(intent);

            }
        });
    myDialog.show();
    }
}
