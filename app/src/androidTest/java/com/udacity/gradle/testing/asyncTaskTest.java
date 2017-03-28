package com.udacity.gradle.testing;//import android.app.Application;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import com.example.MyLib;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import java.util.concurrent.CountDownLatch;

public class asyncTaskTest extends ApplicationTestCase {

    String res = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public asyncTaskTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testAlbumGetTask() throws InterruptedException {

        new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                res = result;
                signal.countDown();
            }
        }.execute(getContext());
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(res));
        assertEquals(res, MyLib.getJoke());

    }
}