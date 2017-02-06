package com.example.adityavd.androidprojects;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ADITYA VD on 27-06-2016.
 */
public class MyBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "MESSAGE BROADCASTED", Toast.LENGTH_SHORT).show();
    }
}
