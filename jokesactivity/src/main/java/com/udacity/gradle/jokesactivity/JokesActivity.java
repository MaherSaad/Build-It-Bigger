package com.udacity.gradle.jokesactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        TextView textView = (TextView)findViewById(R.id.joke);
        textView.setText(getIntent().getStringExtra("joke"));
    }
}
