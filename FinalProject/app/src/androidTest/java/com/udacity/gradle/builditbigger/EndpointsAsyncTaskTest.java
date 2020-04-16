package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
class EndpointsAsyncTaskTest {

    private static final int COUNT = 1;

    private static final int TIME_OUT = 10;

    private String mJokes = null;

    private Exception mException = null;


    private EndpointsAsyncTask.OnTaskComplete mCallback = new EndpointsAsyncTask.OnTaskComplete() {
        @Override
        public void onTaskComplete(String jokeResult) {
        }

        @Override
        public void onPreTask() {
        }
    };

    private CountDownLatch mSignal = null;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        // Construct a CountDownLatch initialized with the given count
        mSignal = new CountDownLatch(COUNT);
    }

    @Test
    public void checkNonEmptyString() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask(mCallback);
        AsyncTask<Pair<Context, String>, Void, String> manfred = task.setListener(new EndpointsAsyncTask.EndpointsAsyncTaskListener() {
            @Override
            public void onComplete(String jokeResult, Exception e) {
                mJokes = jokeResult;
                mException = e;
                // Decrement the count of the latch, releasing all waiting threads if the count
                // reaches zero
                mSignal.countDown();
            }
        }).execute(new Pair<Context, String>(InstrumentationRegistry.getInstrumentation().getContext(), "Manfred"));

        // Causes the current thread to wait until the latch has counted down to zero,
        // unless the thread is interrupted, or the specified waiting time elapses.
        mSignal.await(TIME_OUT, TimeUnit.SECONDS);

        // Verify that the exception is null
        assertNull(mException);
        // Verify that the received joke string is not null
        assertTrue(mJokes, mJokes != null);
        // Verify that the received joke string is not empty
        assertTrue(mJokes, !mJokes.isEmpty());

    }

}