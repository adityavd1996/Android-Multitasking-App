package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonTest extends AppCompatActivity {

    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_test);

        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        r3 = (RadioButton) findViewById(R.id.rb3);
        r4 = (RadioButton) findViewById(R.id.rb4);
        rg= (RadioGroup)findViewById(R.id.rg);
        button = (Button) findViewById(R.id.button);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RadioButton r = (RadioButton)v;
                Toast.makeText(RadioButtonTest.this, "You have selected"+" "+((RadioButton) v).getText(), Toast.LENGTH_SHORT).show();
            }
        };
        r1.setOnClickListener(listener);
        r2.setOnClickListener(listener);
        r3.setOnClickListener(listener);
        r4.setOnClickListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg.clearCheck();
            }
        });
    }
}

