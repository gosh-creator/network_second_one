package com.example.network.news;

import com.example.network.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView description;
    ImageView imageView;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.item_name);
        description = itemView.findViewById(R.id.item_description);
        imageView = itemView.findViewById(R.id.item_imageView);

    }
}
