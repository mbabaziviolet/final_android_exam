package com.example.signupmaterial;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    TextView tv2,tv5;
    Button btn3,btn4;
    ListView listView; //declaration
    String[] names={"Android Development","Web Development","Data Science","Python Programming","Machine Learning","React"};
    ArrayAdapter<String > arrayAdapter;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.welcome);
            //assign listview variable to a value
            listView = (ListView) findViewById(R.id.listView);
            tv2 = (TextView) findViewById(R.id.tv2);
            tv5 = (TextView) findViewById(R.id.tv5);
            btn3 =(Button) findViewById(R.id.btn3);
            btn4 =(Button) findViewById(R.id.btn4);

            arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
            listView.setAdapter(arrayAdapter);
        }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu,menu);
            MenuItem menuItem =menu.findItem(R.id.menu_search);
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setQueryHint("Type here to search");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);
        }


    }








