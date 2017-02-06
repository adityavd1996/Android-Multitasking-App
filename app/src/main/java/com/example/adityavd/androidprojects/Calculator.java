package com.example.adityavd.androidprojects;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener{
    Button a,s,d,m,button;
    TextView tvresult;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        a=(Button)findViewById(R.id.add);
        s=(Button)findViewById(R.id.sub);
        d=(Button)findViewById(R.id.div);
        m=(Button)findViewById(R.id.mul);
        et1=(EditText)findViewById(R.id.etFirstNo);
        et2=(EditText)findViewById(R.id.etSecondNo);
        tvresult=(TextView) findViewById(R.id.tvResult);
        button=(Button)findViewById(R.id.button);
        a.setOnClickListener(this);
        s.setOnClickListener(this);
        d.setOnClickListener(this);
        m.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvresult.setText(" ");
            }
        });
    }

    @Override
    public void onClick(View v) {
        String num1=et1.getText().toString();
        String num2=et2.getText().toString();
        switch (v.getId()){
            case R.id.add:
                int Addition=Integer.parseInt(num1)+Integer.parseInt(num2);
                tvresult.setText(String.valueOf(Addition));
                break;
            case R.id.sub:
                int Subtraction=Integer.parseInt(num1)-Integer.parseInt(num2);
                tvresult.setText(String.valueOf(Subtraction));
                break;
            case R.id.div:
                try
                {
                    int Division=Integer.parseInt(num1)/Integer.parseInt(num2);
                    tvresult.setText(String.valueOf(Division));
                    break;}catch (Exception e){
                    tvresult.setText("Cannot divide");
                }
            case R.id.mul:
                int Multi=Integer.parseInt(num1)*Integer.parseInt(num2);
                tvresult.setText(String.valueOf(Multi));
                break;
        }
    }
}
