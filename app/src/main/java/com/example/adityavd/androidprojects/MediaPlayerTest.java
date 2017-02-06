package com.example.adityavd.androidprojects;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MediaPlayerTest extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {

ImageButton play;
    Button stop;
    TextView tv;
    SeekBar sb;
    MediaPlayer mp;
    Thread progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player_test);
        play = (ImageButton) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.button2);
        sb = (SeekBar) findViewById(R.id.sb);
        tv = (TextView) findViewById(R.id.tv1);
        mp = MediaPlayer.create(this, R.raw.stressedout);
        sb.setMax(mp.getDuration());
        tv.setText(convertDuration(mp.getDuration()));

        progress = new Thread() {
            @Override
            public void run() {
                while (mp.getDuration() != mp.getCurrentPosition()) {
                    sb.setProgress(mp.getCurrentPosition());
                }

            }
        };
        progress.start();
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        sb.setOnSeekBarChangeListener(this);

    }
String convertDuration(long l)
{
    String td="";
    long l1=l/1000;
    td=td+l1/60+":"+l1%60;
    return td;
}


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.play:
                if (!mp.isPlaying()) {
                    play.setImageResource(android.R.drawable.ic_media_pause);
                    mp.start();
                } else {
                    play.setImageResource(android.R.drawable.ic_media_play);
                    mp.pause();
                }
                break;
            case R.id.button2:
                if(mp.isPlaying()) {
                    mp.pause();

                }
                    break;
                    default:
                        break;
                }
        }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
if(fromUser)
    mp.seekTo(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
