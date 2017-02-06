package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Counter extends AppCompatActivity implements View.OnClickListener{

    Button a,b,c;
    TextView tv5;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        a=(Button)findViewById(R.id.button);
        b=(Button)findViewById(R.id.dec);
        c=(Button)findViewById(R.id.clear);
        tv5=(TextView)findViewById(R.id.tv1);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                count++;
                tv5.setText("Count="+" "+String.valueOf(count));
                break;
            case R.id.dec:
                count--;
                tv5.setText("Count="+" "+String.valueOf(count));
                break;
            case R.id.clear:
                count=0;
                tv5.setText("Count="+" "+String.valueOf(count));

        }
    }
}
