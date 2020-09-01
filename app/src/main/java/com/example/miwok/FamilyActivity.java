package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> familyWords = new ArrayList<>();
        createFamilyList(familyWords);
        createListView(familyWords);
    }

    private void createFamilyList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        arrayList.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        arrayList.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        arrayList.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        arrayList.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        arrayList.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        arrayList.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        arrayList.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        arrayList.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        arrayList.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));
    }

    private void createListView(final ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList, R.color.category_family);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = arrayList.get(position);
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getMediaPlayer());
                mMediaPlayer.start();
            }
        });
    }
}