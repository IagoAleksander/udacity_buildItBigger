package com.iaz.androidjoker;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        ArrayList<Integer> colorsList = new ArrayList<>(
                Arrays.asList(getResources().getColor(R.color.red_500),
                        getResources().getColor(R.color.purple_500),
                        getResources().getColor(R.color.deep_purple_500),
                        getResources().getColor(R.color.blue_500),
                        getResources().getColor(R.color.blue_500),
                        getResources().getColor(R.color.teal_500),
                        getResources().getColor(R.color.green_500),
                        getResources().getColor(R.color.yellow_900),
                        getResources().getColor(R.color.deep_orange_500)));

        TextView textview = findViewById(R.id.joke_text);
        ConstraintLayout constraintLayout = findViewById(R.id.cl_main);
        Button button = findViewById(R.id.bt_joke);

        String jokeResult = getIntent().getStringExtra(Constants.JOKE_BUNDLE);

        if (jokeResult != null) {
            textview.setText(jokeResult);

            Random r = new Random();
            int color = colorsList.get(r.nextInt(colorsList.size()));
            textview.setTextColor(color);
            constraintLayout.setBackgroundColor(color);
            button.setTextColor(color);

        } else {
            textview.setText(R.string.general_error);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
