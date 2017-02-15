package com.chablis.syplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chablis.syplayer.application.Settings;
import com.chablis.syplayer.widget.media.AndroidMediaController;
import com.chablis.syplayer.widget.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity {
private Settings mSettings;
    private IjkVideoView videoView;
    private AndroidMediaController mMediaController;
    private String path="http://baobab.wdjcdn.com/145076769089714.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaController = new AndroidMediaController(this, false);

        mSettings = new Settings(this);
        videoView = (IjkVideoView) findViewById(R.id.videoview);
        // init player
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mMediaController);

        videoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
                videoView.start();
            }
        });
    }
}
