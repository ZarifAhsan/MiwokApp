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
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMediaPlayer());
                mMediaPlayer.start();
            }
        });
    }
}