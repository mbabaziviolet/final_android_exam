package com.example.signupmaterial;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_2;
    EditText name,reg, password;
    String nam,regi,pass;
    Intent intent, intent_2;
    TextView t_register,toadmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn_2 = (Button) findViewById(R.id.login_button);
        name = (EditText) findViewById(R.id.name);
        reg = (EditText) findViewById(R.id.reg1);
        password = (EditText) findViewById(R.id.passw);
        t_register = (TextView) findViewById(R.id.btn_log);
        toadmin = findViewById(R.id.toadminpage);



        toadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_2 = new Intent(getApplicationContext(), LoginAdmin.class);
                startActivity(intent_2);
            }
        });


        t_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_2 = new Intent(getApplicationContext(), SignUpForm.class);
                startActivity(intent_2);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam = name.getText().toString();
                regi = reg.getText().toString();
                pass = password.getText().toString();


                if (nam.isEmpty()) {
                    name.setError("Please enter your name");
                }


                if (regi.isEmpty()) {
                    reg.setError("Please enter your email");
                }
                if (pass.isEmpty()) {
                    password.setError("Please enter your password");

                } else {
                    intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }}










