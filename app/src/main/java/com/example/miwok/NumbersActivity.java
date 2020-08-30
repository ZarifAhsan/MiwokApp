package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        ArrayList<String> numberWords = new ArrayList<String>();

        createNumberList(numberWords);
        createListView(numberWords);
    }

    private void createNumberList(ArrayList<String> arrayList) {
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayList.add("six");
        arrayList.add("seven");
        arrayList.add("eight");
        arrayList.add("nine");
        arrayList.add("ten");
    }

    private void createListView(ArrayList<String> arrayList) {
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, arrayList);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

}