package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void openNumbersList(View view) {
        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent);
    }

    public void openFamilyList(View view) {
        Intent intent = new Intent(this, FamilyActivity.class);
        startActivity(intent);
    }

    public void openPhrasesList(View view) {
        Intent intent = new Intent(this, PhrasesActivity.class);
        startActivity(intent);
    }

    public void openColorsList(View view) {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent);
    }

}