package com.example.adityavd.androidprojects;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by ADITYA VD on 30-06-2016.
 */
public class MyService extends Service implements MediaPlayer.OnCompletionListener {
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    mp=MediaPlayer.create(this,R.raw.stressedout);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!mp.isPlaying())
            mp.start();
            return START_STICKY;
        }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    if(!mp.isPlaying())
        mp.start();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
            stopSelf();
        }

    @Override
    public void onDestroy() {
        super.onDestroy();
    mp.release();
        stopSelf();
    }
}
