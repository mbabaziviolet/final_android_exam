package com.example.signupmaterial;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
    TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);
        tv1 = (TextView) findViewById(R.id.txt1);


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Home());
            }

        });
    }
    private void loadFragment(Fragment fragment) {
// create a FragmentManager to interact with all fragments
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();


    }}

