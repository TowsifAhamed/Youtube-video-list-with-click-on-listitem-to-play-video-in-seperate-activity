package com.example.youtubevideolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class videoplayerActivity extends YouTubeBaseActivity {
    private static final String TAG = "videoplayerActivity";
    YouTubePlayerView youTubePlayerView;
    Button play;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        Log.d(TAG,"onCreate:Starting");
        Bundle bundle = getIntent().getExtras();
        final String url = bundle.getString("url");
        play=findViewById(R.id.playbutton);
        youTubePlayerView=findViewById(R.id.player);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick:Done Initializing");
                youTubePlayer.loadVideo(url);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick:Failed to Initialize");
            }
        };
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick:Starting player");
                youTubePlayerView.initialize(youtubeconfig.getApiKey(),onInitializedListener);
            }
        });
    }
}