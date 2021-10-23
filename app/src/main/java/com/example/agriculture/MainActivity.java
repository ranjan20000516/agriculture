package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.agriculture.utils.CSVImporter;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.login_button);
        button.setOnClickListener(v -> {
            CSVImporter importer = new CSVImporter(this);
            importer.importModels();


            Intent intent1=new Intent(MainActivity.this,Screen_2.class);
            startActivity(intent1);
            finish();
        });

       signUpButton=findViewById(R.id.signUp);
       signUpButton.setOnClickListener(v -> {
         Intent registerIntent=new Intent(MainActivity.this, RegisterActivity.class);
         startActivity(registerIntent);
         finish();
        });


    }
}