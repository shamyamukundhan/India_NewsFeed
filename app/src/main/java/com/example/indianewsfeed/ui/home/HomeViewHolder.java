package com.example.indianewsfeed.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianewsfeed.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {
    TextView text_title,text_source;
    ImageView img_headline;
    CardView cardView;


    public HomeViewHolder( View itemView) {
        super(itemView);
        text_title =itemView.findViewById(R.id.text_title);
        text_source=itemView.findViewById(R.id.text_source);
        img_headline=itemView.findViewById(R.id.img_headline);
        cardView=itemView.findViewById(R.id.main_container);

    }
}
