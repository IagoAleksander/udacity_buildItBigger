package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = new MainFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fl_main, mainFragment)
                .commit();


        new EndpointAsyncTask().execute(this);
    }
}
