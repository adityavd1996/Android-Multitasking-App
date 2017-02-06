package com.example.adityavd.androidprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.EventListener;
import java.util.List;

public class Sensor1Test extends AppCompatActivity {
    List<Sensor> l;
    SensorManager sm;
    TextView tv;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float X=event.values[0];
            float Y=event.values[1];
            float Z=event.values[2];
            tv.setText("AZIMUTH :"+X+"\n PITCH:"+Y+"\n ROLL:"+Z);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor1_test);
        tv=(TextView)findViewById(R.id.tv);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        l=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(sel,l.get(0),SensorManager.SENSOR_DELAY_NORMAL);
    }
}
