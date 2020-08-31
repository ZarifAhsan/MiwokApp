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
        arrayList.add(new Word("one", "lutti", R.drawable.number_one));
        arrayList.add(new Word("two", "otiiko", R.drawable.number_two));
        arrayList.add(new Word("three", "tolookosu", R.drawable.number_three));
        arrayList.add(new Word("four", "oyyisa", R.drawable.number_four));
        arrayList.add(new Word("five", "massokka", R.drawable.number_five));
        arrayList.add(new Word("six", "temmokka", R.drawable.number_six));
        arrayList.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        arrayList.add(new Word("eight", "kawinta", R.drawable.number_eight));
        arrayList.add(new Word("nine", "wo'e", R.drawable.number_nine));
        arrayList.add(new Word("ten", "na'aacha", R.drawable.number_ten));
    }

    private void createListView(ArrayList<Word> arrayList) {
        WordAdapter wordAdapter = new WordAdapter(this, arrayList, R.color.category_numbers);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }

}