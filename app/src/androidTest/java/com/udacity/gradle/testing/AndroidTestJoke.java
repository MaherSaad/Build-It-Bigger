package com.udacity.gradle.testing;

import android.support.test.runner.AndroidJUnit4;

import com.example.MyLib;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class AndroidTestJoke {

    @Test
    public void testJoke() {
        assertEquals("derp", MyLib.getJoke());
    }

}
