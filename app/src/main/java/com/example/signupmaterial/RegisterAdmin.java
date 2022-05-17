package com.example.signupmaterial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterAdmin extends Activity {

    Button admin_login;
    Button sign_up;
    EditText name, email,password1,confirm;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_admin);


        //targeting views

        admin_login = findViewById(R.id.admin_Login);
        sign_up = findViewById(R.id.signup_button);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email1);
        password1 = (EditText) findViewById(R.id.pass1);
        confirm = (EditText) findViewById(R.id.confirm);
        db = new DBHelper(this);



        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginAdmin.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String admin_name = name.getText().toString().trim();
                String admin_email = email.getText().toString().trim();
                String admin_password = password1.getText().toString().trim();
                String confirm_password= confirm.getText().toString().trim();


                if(admin_name.equals("")   || admin_email.equals("") || admin_password.equals("")  ){
                    Toast.makeText(RegisterAdmin.this, "All fields are required", Toast.LENGTH_SHORT).show();

                }
                else{

                    if(admin_password.equals(confirm_password)){



                        Boolean checkadminname = db.checkAdminName(admin_name);

                        if(checkadminname==false){
                            //admin emaildev

                            Boolean checkadminemail = db.checkAminEmail(admin_email);

                            if(checkadminemail==false){

                                Boolean insert = db.RegisterAdmin(admin_email,admin_name,admin_password);
                                if(insert==true){
                                    Toast.makeText(RegisterAdmin.this, "Successfully created ", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginAdmin.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(RegisterAdmin.this, "failed to register", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(RegisterAdmin.this, "email exists", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(RegisterAdmin.this, "username is already in use", Toast.LENGTH_SHORT).show();
                        }



                    }else{
                        Toast.makeText(RegisterAdmin.this, "Passwords don't match", Toast.LENGTH_SHORT).show();

                    }

                }


            }
        });



        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginAdmin.class);
                startActivity(intent);
            }
        });
    }
}