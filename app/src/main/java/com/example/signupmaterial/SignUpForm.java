package com.example.signupmaterial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpForm extends Activity {
    TextView t_login;
    Button btn_2;
    EditText username,email, password,conf_pass;
    String user,em,pass,conf;
    Intent intent,intent_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_form);


        btn_2 = (Button) findViewById(R.id.signup_button);
        t_login = (TextView) findViewById(R.id.text_login);
        username = (EditText) findViewById(R.id.user_name);
        email = (EditText) findViewById(R.id.address_1);
        password = (EditText) findViewById(R.id.pass1);
        conf_pass = (EditText) findViewById(R.id.confirm);


        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = username.getText().toString();
                em = email.getText().toString();
                pass = password.getText().toString();
                conf = conf_pass.getText().toString();

                if (user.isEmpty()) {
                    username.setError("Please enter your username");
                }
                if (em.isEmpty()) {
                    email.setError("Please enter your address");
                }

                if (pass.isEmpty()) {
                    password.setError("Please enter your password");
                }
                if (conf.isEmpty()) {
                    conf_pass.setError("Please confirm your password");

//                if (pass != conf) {
//
//                    conf_pass.setError("Passwords don't match");

                } else{
                    intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }


            }
        });
        t_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent_1);
            }
        });

    }
}

