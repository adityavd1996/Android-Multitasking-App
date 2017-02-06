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
import android.widget.ImageView;

import java.util.List;

public class SensorTest2 extends AppCompatActivity {
    List<Sensor> l;
    SensorManager sm;
    ImageView iv;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            Float X=event.values[0];
            if(X==0)
            {
                iv.setImageResource(R.drawable.avd);
            }
            else
            {
                iv.setImageResource(R.drawable.abc);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test2);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        l=sm.getSensorList(Sensor.TYPE_PROXIMITY);
        iv=(ImageView)findViewById(R.id.iv);
        sm.registerListener(sel,l.get(0),SensorManager.SENSOR_DELAY_NORMAL);
    }

}