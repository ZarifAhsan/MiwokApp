package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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


        final ArrayList<Word> numberWords = new ArrayList<>();

        createNumberList(numberWords);
        createListView(numberWords);
    }

    private void createNumberList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        arrayList.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        arrayList.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        arrayList.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        arrayList.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        arrayList.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        arrayList.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        arrayList.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        arrayList.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        arrayList.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
    }

    private void createListView(final ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = arrayList.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getMediaPlayer());
                mMediaPlayer.start();

               mMediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });
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