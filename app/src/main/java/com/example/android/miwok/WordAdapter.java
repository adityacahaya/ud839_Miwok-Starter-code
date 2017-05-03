package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.finishOnCloseSystemDialogs;
import static android.R.attr.id;
import static android.R.attr.resource;
import static android.R.attr.writePermission;

/**
 * Created by I Kadek Aditya on 5/1/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int color;
    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context,0,words);
    }

    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context,0,words);
        this.color = color;
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word word = getItem(position);

        View view = listItemView.findViewById(R.id.textList);
        int color = ContextCompat.getColor(getContext(),this.color);
        view.setBackgroundColor(color);

        /*
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(this.getContext(),word.getSoundId());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
        */

        TextView defaultLanguage = (TextView) listItemView.findViewById(R.id.tv_english);
        defaultLanguage.setText(word.getDefaultLanguage());

        TextView miwokLanguage = (TextView) listItemView.findViewById(R.id.tv_miwok);
        miwokLanguage.setText(word.getMiwokLanguage());

        ImageView imgApp = (ImageView) listItemView.findViewById(R.id.img_list);
        if(word.hasImage()){
            imgApp.setImageResource(word.getImageId());
            imgApp.setVisibility(View.VISIBLE);
        }else{
            imgApp.setVisibility(View.GONE);
        }

        return listItemView;
    }

}
