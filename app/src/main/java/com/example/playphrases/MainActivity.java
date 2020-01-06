package com.example.playphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    public void playPhrase(View view) {

        int id = view.getId();

        String myID = view.getResources().getResourceEntryName(id);

        int resourceID = getResources().getIdentifier(myID, "raw", "com.example.playphrases");

        mp = MediaPlayer.create(this, resourceID);
        mp.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        mp.release();
        super.onDestroy();
    }
}
