package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.iaz.androidjoker.DisplayJokeActivity;

import static com.udacity.gradle.builditbigger.Constants.JOKE_BUNDLE;

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
    }

    public void displayJoke(String joke) {
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra(JOKE_BUNDLE,joke);
        startActivity(intent);
    }
}
