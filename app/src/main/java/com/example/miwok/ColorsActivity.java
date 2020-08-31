package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorWords = new ArrayList<>();

        createColorList(colorWords);
        createListView(colorWords);
    }

    private void createColorList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("red", "weṭeṭṭi", R.drawable.ic_launcher_background));
        arrayList.add(new Word("green", "chokokki", R.drawable.ic_launcher_background));
        arrayList.add(new Word("brown", "ṭakaakki", R.drawable.ic_launcher_background));
        arrayList.add(new Word("gray", "ṭopoppi", R.drawable.ic_launcher_background));
        arrayList.add(new Word("black", "kululli", R.drawable.ic_launcher_background));
        arrayList.add(new Word("white", "kelelli", R.drawable.ic_launcher_background));
        arrayList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.ic_launcher_background));
        arrayList.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.ic_launcher_background));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}