package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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

        // get userName from the MainActivity
        String userName = i.getStringExtra("name");

        // Random Number Generated
        int randomNumber = generateRandomNumber();

        luckyNumberTxt.setText("" + randomNumber);


    }

    public int generateRandomNumber() {
        // Random class
        Random random = new Random();
        int upper_limit = 1000;

        // 1000 is not included
        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;
    }

}