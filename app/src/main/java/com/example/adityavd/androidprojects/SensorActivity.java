package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SensorActivity extends AppCompatActivity {
    TextView tv;
    Sensor s;
    SensorManager sm;
    List<Sensor> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tv=(TextView)findViewById(R.id.tv);
        if (sm==null)
            Toast.makeText(SensorActivity.this, "old phone", Toast.LENGTH_SHORT).show();
        l=sm.getSensorList(Sensor.TYPE_ALL);
        String s="";
        for (Sensor s1:l)
        {
            s=s+s1.getName()+"||"+s1.getType()+"||"+s1.getVendor()+"\n";
        }
        tv.setText(s);
    }
}
