package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EndpointAsyncTaskTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @SuppressWarnings("unchecked")
    @Test
    //  tests to verify that the AsyncTask is indeed loading jokes.
    public void checkJokeFetched() {
        String result = null;
        EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask();
        endpointsAsyncTask.execute(activityActivityTestRule.getActivity());
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // check that the fetched info is not null neither empty
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }
}