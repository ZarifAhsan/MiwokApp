package com.example.miwok.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.miwok.R;
import com.example.miwok.utils.Word;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private final int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> Word, int colorResourceId) {
        super(context, 0, Word);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }



        Word currentWord = getItem(position);

        TextView defaultWordView = listItemView.findViewById(R.id.default_word_text_view);
        assert currentWord != null;
        defaultWordView.setText(currentWord.getDefaultTranslation());

        TextView miwokWordView = listItemView.findViewById(R.id.miwok_word_text_view);
        miwokWordView.setText(currentWord.getMiwokTranslation());


        ImageView imageView = listItemView.findViewById(R.id.number_word_icon_image_view);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }


}
