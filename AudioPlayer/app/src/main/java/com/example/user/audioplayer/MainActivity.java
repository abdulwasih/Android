package com.example.user.audioplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //mediaPlayer object creation
    MediaPlayer mediaPlayer;

    //audioManager
    AudioManager audioManager;

    public void playme(View view)
    {
        mediaPlayer.start();
    }

    public void pauseme(View view)
    {
       mediaPlayer.pause();
    }
    public void stopme(View view)
    {
        mediaPlayer.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mediaplayer creation
        mediaPlayer = MediaPlayer.create(this,R.raw.song);

        //Getting context from Audio Service
        audioManager =(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int myMaxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int myCurrentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //Setting context values to Seekbar
        SeekBar volumeRocker=(SeekBar)findViewById(R.id.seekBar);
        volumeRocker.setMax(myMaxVolume);
        volumeRocker.setProgress(myCurrentVolume);

        //Set on change listener
        volumeRocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //Setting timeline

        final SeekBar tmieline = (SeekBar) findViewById(R.id.timeline);
        tmieline.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tmieline.setProgress(mediaPlayer.getCurrentPosition());

            }
        },0,1000);

        tmieline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.seekTo(i);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
