package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorWords = new ArrayList<>();

        createColorList(colorWords);
        createListView(colorWords);
    }

    private void createColorList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        arrayList.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        arrayList.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        arrayList.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        arrayList.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        arrayList.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        arrayList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        arrayList.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
    }

    private void createListView(final ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList, R.color.category_colors);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = arrayList.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMediaPlayer());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}