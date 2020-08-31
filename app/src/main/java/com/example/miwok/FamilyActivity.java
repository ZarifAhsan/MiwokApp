package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyWords = new ArrayList<>();
        createFamilyList(familyWords);
        createListView(familyWords);
    }

    private void createFamilyList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("father", "әpә", R.drawable.ic_launcher_background));
        arrayList.add(new Word("mother", "әṭa", R.drawable.ic_launcher_background));
        arrayList.add(new Word("son", "angsi", R.drawable.ic_launcher_background));
        arrayList.add(new Word("daughter", "tune", R.drawable.ic_launcher_background));
        arrayList.add(new Word("older brother", "taachi", R.drawable.ic_launcher_background));
        arrayList.add(new Word("younger brother", "chalitti", R.drawable.ic_launcher_background));
        arrayList.add(new Word("older sister", "teṭe", R.drawable.ic_launcher_background));
        arrayList.add(new Word("younger sister", "kolliti", R.drawable.ic_launcher_background));
        arrayList.add(new Word("grandmother", "ama", R.drawable.ic_launcher_background));
        arrayList.add(new Word("grandfather", "paapa", R.drawable.ic_launcher_background));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}