package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Temperature extends AppCompatActivity implements View.OnClickListener{
    RadioButton cels,fahr;
    RadioGroup rg1;
    Button button;
    TextView tv;
    EditText et12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        cels=(RadioButton)findViewById(R.id.cel);
        fahr=(RadioButton) findViewById(R.id.fah);
        et12=(EditText)findViewById(R.id.et1);
        rg1=(RadioGroup)findViewById(R.id.rg);
        tv=(TextView) findViewById(R.id.tv);
        button=(Button)findViewById(R.id.button);
        cels.setOnClickListener(this);
        fahr.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("0");
                rg1.clearCheck();
                et12.setText("0");
            }
        });
    }
    @Override
    public void onClick(View v) {
        String num1 = et12.getText().toString();
        switch (v.getId()) {
            case R.id.fah:
                float Addition = (float) (
                        Integer.parseInt(num1) *1.8) + 32;
                tv.setText(String.valueOf(Addition));

                break;
            case R.id.cel:
                float Subtraction = (float) (
                        (Integer.parseInt(num1) -32) + .555);
                tv.setText(String.valueOf(Subtraction));
                break;

        }
    }

}

