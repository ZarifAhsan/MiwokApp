package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> numberWords = new ArrayList<>();

        createNumberList(numberWords);
        createListView(numberWords);
    }

    private void createNumberList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("one", "lutti", R.drawable.ic_launcher_background));
        arrayList.add(new Word("two", "otiiko", R.drawable.ic_launcher_background));
        arrayList.add(new Word("three", "tolookosu", R.drawable.ic_launcher_background));
        arrayList.add(new Word("four", "oyyisa", R.drawable.ic_launcher_background));
        arrayList.add(new Word("five", "massokka", R.drawable.ic_launcher_background));
        arrayList.add(new Word("six", "temmokka", R.drawable.ic_launcher_background));
        arrayList.add(new Word("seven", "kenekaku", R.drawable.ic_launcher_background));
        arrayList.add(new Word("eight", "kawinta", R.drawable.ic_launcher_background));
        arrayList.add(new Word("nine", "wo'e", R.drawable.ic_launcher_background));
        arrayList.add(new Word("ten", "na'aacha", R.drawable.ic_launcher_background));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }

}