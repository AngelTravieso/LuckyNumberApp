package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LuckyNumberActivity extends AppCompatActivity {

    // declaring widgets
    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        // initialize widgets
        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

        Intent i = getIntent();

        // get data from the MainActivity
        String userName = i.getStringExtra("name");

        Toast.makeText(this, "Username: " + userName, Toast.LENGTH_SHORT).show();



    }
}