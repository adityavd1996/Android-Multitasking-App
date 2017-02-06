package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

public class Switch extends AppCompatActivity {

    android.widget.Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        s=(android.widget.Switch)findViewById(R.id.sw);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                    Toast.makeText(Switch.this,"WIFI ON",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Switch.this,"WIFI OFF",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
