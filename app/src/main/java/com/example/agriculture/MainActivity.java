package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.login_button);
        button.setOnClickListener(v -> {

            Intent intent1=new Intent(MainActivity.this,Screen_2.class);
            startActivity(intent1);
            finish();
        });

    }
}