package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Screen_4 extends AppCompatActivity {

    private String headline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        headline=getIntent().getStringExtra("headline");
        TextView headlineText=findViewById(R.id.headlines);
        headlineText.setText(headline);
    }
}