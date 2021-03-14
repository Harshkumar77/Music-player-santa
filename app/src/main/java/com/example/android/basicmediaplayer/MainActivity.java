package com.example.android.basicmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hiding the action bar for better view
        getSupportActionBar().hide();

        // MediaPlayer class
        mediaPlayer = MediaPlayer.create(this,R.raw.music);


        Button play = (Button) findViewById(R.id.play);
        //Play button
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses play button
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I'm Done !", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



        //pause button
        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses pause button
                mediaPlayer.pause();
            }
        });

        //pause button
        Button reset = (Button) findViewById(R.id.reset);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses reset button
                mediaPlayer.reset();

            }
        });
    }
}