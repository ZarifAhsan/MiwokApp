package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesWords = new ArrayList<>();

        createPhrasesList(phrasesWords);
        createListView(phrasesWords);
    }

    private void createPhrasesList(ArrayList<Word> arrayList) {
        arrayList.add(new Word("Where are you going?", "minto wuksus?"));
        arrayList.add(new Word("What is your name?", "tinnә oyaase'nә?"));
        arrayList.add(new Word("My name is...", "oyaaset..."));
        arrayList.add(new Word("How are you feeling?", "michәksәs?"));
        arrayList.add(new Word("I'm feeling good.", "kuchi achit"));
        arrayList.add(new Word("Are you coming?", "әәnәs'aa?"));
        arrayList.add(new Word("Yes, I'm coming.", "hәә’ әәnәm"));
        arrayList.add(new Word("I'm coming", "әәnәm"));
        arrayList.add(new Word("Let's go.", "yoowutis"));
        arrayList.add(new Word("Come here.", "әnni'nem"));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }

}