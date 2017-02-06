package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckBoxTest extends AppCompatActivity {

    CheckBox c1,c2,c3,c4;
    Button button;
    TextView tvv,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_test);

        c1 = (CheckBox) findViewById(R.id.ch1);
        c2 = (CheckBox) findViewById(R.id.ch2);
        c3 = (CheckBox) findViewById(R.id.ch3);
        c4 = (CheckBox) findViewById(R.id.ch4);
        tvv = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.t_v);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = "Your favorite Soccer team is";
                if (c1.isChecked()) {
                    res = res + "\n" + c1.getText();
                }
                if (c2.isChecked()) {
                    res = res + "\n" + c2.getText();
                }
                if (c3.isChecked()) {
                    res = res + "\n" + c3.getText();
                }
                if (c4.isChecked()) {
                    res = res + "\n" + c4.getText();
                }

                tvv.setText(String.valueOf(res));
            }


        });
    }
    }
