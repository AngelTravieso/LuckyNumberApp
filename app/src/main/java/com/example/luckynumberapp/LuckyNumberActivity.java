package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        // set luckyNumber to the textView
        luckyNumberTxt.setText("" + randomNumber);


        // action for the share button
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });

    }


    // Generate Random Number
    public int generateRandomNumber() {
        // Random class
        Random random = new Random();
        int upper_limit = 1000;

        // 1000 is not included
        return random.nextInt(upper_limit);
    }


    // Share the data lucky number
    public void shareData(String username, int randomNumber) {
         // Implicit intent
        Intent i = new Intent(Intent.ACTION_SEND);

        // type of data
        i.setType("text/plain");

        // Here I need to pass the title and the body of the message
        i.putExtra(Intent.EXTRA_SUBJECT, username); // title of the email
        i.putExtra(Intent.EXTRA_TEXT, randomNumber); // body

        // Choose platform for share the data (lucky number)
        startActivity(Intent.createChooser(i, "Choose a platform"));

    }

}