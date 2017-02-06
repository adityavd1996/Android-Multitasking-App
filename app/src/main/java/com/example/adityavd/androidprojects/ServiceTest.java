package com.example.adityavd.androidprojects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceTest extends AppCompatActivity implements View.OnClickListener{
Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    start=(Button)findViewById(R.id.button3);
        stop=(Button)findViewById(R.id.button4);
    start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
       Intent i=new Intent(this,MyService.class);
        switch (v.getId())
        {
            case R.id.button3:
                startService(i);
                break;
            case R.id.button4:
                stopService(i);
                break;
            default:break;
        }
    }
}
