package com.example.dropitlo.youtubeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity
    implements View.OnClickListener{

    private String GOOGLE_API_KEY = "AIzaSyAI7nsjiPv9WqEDU3n23wLdWDr8bGm7Bys";
    private String YOUTUBE_VIDEO_ID = "0lBjcaMokvo";
    private String YOUTUBE_PLAYLIST = "PLUl4u3cNGP62K2DjQLRxDNRi0z2IRWnNh";
    private Button btnPlayVideo;
    private Button btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlaylist = (Button) findViewById(R.id.btnPlaylist);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);

        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY,YOUTUBE_PLAYLIST);
                break;
            default:
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
