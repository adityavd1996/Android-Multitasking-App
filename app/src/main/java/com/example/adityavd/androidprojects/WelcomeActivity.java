package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView=(TextView)findViewById(R.id.textView4);
        Bundle b=getIntent().getExtras();

        textView.setText("WELCOME DEAR"+" "+b.getString("un").toUpperCase());
    }
}
