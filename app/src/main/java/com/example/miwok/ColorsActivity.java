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
        arrayList.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        arrayList.add(new Word("green", "chokokki", R.drawable.color_green));
        arrayList.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        arrayList.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        arrayList.add(new Word("black", "kululli", R.drawable.color_black));
        arrayList.add(new Word("white", "kelelli", R.drawable.color_white));
        arrayList.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow));
        arrayList.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList, R.color.category_colors);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}