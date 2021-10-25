package com.example.agriculture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agriculture.R;
import com.example.agriculture.models.UserModel;

public class RegisterActivity extends AppCompatActivity {
    EditText usernameET , emailET , passwordET, conPasswordET;
    Button btn;
    private DatabaseHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameET = findViewById(R.id.userNameText);
        emailET = findViewById(R.id.emailText);
        passwordET = findViewById(R.id.passwordText);
        conPasswordET = findViewById(R.id.confirmPasswordText);
        btn = findViewById(R.id.registerButton);
        handler = new DatabaseHandler(this);
        btn.setOnClickListener(v -> {
        final String username=usernameET.getText().toString().trim();
        final String email=emailET.getText().toString().trim();
        final String password = passwordET.getText().toString().trim();

            if(!passwordET.getText().toString().equals(conPasswordET.getText().toString())){
                  Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
              }
            else{
                  UserModel model= new UserModel(username , email,password);
                  handler.addUser(model);
                Toast.makeText(this, "User successfully created", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent1);
                finish();
              }

        });

    }
}