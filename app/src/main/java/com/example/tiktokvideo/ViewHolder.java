package com.example.tiktokvideo;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    VideoView videoView;
    ProgressBar bar;
    TextView title, desc;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        videoView = (VideoView) itemView.findViewById(R.id.videoView);
        title = (TextView) itemView.findViewById(R.id.title_header);
        desc = (TextView) itemView.findViewById(R.id.description);
        bar = (ProgressBar) itemView.findViewById(R.id.bar);
    }

    public void setData(Model obj)
    {
        videoView.setVideoPath(obj.getUrl());
        title.setText(obj.getTitle());
        desc.setText(obj.getDesc());

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                bar.setVisibility(View.GONE);
                mp.start();
            }
        });
    }
}
