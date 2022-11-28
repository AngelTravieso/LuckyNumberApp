package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaring widgets
    EditText editText;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets
        editText = findViewById(R.id.editText);
        txt = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass data to the second activity

                // get the name of the user
                String user_name = editText.getText().toString();

                // If the input is not empty
                if(!user_name.isEmpty()) {
                    // Navigate using a explicit intent
                    Intent i = new Intent(getApplicationContext(), LuckyNumberActivity.class);


                    // passing the name to second activity
                    i.putExtra("name", user_name);

                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a valid name", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}