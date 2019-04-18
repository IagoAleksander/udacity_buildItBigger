package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.iaz.androidjoker.DisplayJokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class EndpointAsyncTask extends AsyncTask<Activity, Void, String> {
    private static MyApi myApiService = null;
    private Activity activity;

    @Override
    protected String doInBackground(Activity... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new
                    MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        activity = params[0];


        try {
            return myApiService.tellAJoke().execute().getData();
        } catch (IOException e) {
            Log.d("EndpointAsyncTask", "failed");
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result) {

        if (activity instanceof MainActivity)
            ((MainActivity) activity).displayJoke(result);
    }
} 