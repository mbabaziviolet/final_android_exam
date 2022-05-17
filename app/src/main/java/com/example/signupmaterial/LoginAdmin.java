package com.example.signupmaterial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginAdmin extends Activity {

    EditText email,password;
    Button Loginadmin;
    TextView backhome,btn_log3;
    DBHelper db;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_admin);

        Loginadmin = (Button) findViewById(R.id.loginad_button);
        email = (EditText) findViewById(R.id.emailad);
        password = (EditText) findViewById(R.id.passwordad);
        backhome = (TextView) findViewById(R.id.backhome);
        btn_log3 = findViewById(R.id.btn_log3);
        db = new DBHelper(this);



        //login admin
        Loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adminemail = email.getText().toString();
                String adminpassword = password.getText().toString();


                if(adminemail.equals("")  || adminpassword.equals("")  ){
                    Toast.makeText(LoginAdmin.this, "provide all  values", Toast.LENGTH_SHORT).show();

                }
                else{

                    Boolean checkadminlogincredentials= db.checkAdminAuth(adminemail,adminpassword);

                    if(checkadminlogincredentials==true){


                        Toast.makeText(LoginAdmin.this, "You logged in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AdminDashboard.class);
                        startActivity(intent);


                    }
                    else{
                        Toast.makeText(LoginAdmin.this, " failed to login", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_page = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(home_page);

            }
        });
        btn_log3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterAdmin.class);
                startActivity(intent);
            }
        });

    }
}
