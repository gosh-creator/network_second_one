package com.example.network.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import com.example.network.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder>{

    private ArrayList<News> newsArrayList;

    public NewsAdapter(ArrayList<News> news){
        this.newsArrayList = news;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item_feed, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.name.setText(newsArrayList.get(position).getName());
        holder.description.setText(newsArrayList.get(position).getDescription());
        Glide.with(holder.itemView.getContext()).load(newsArrayList.get(position).getImageView()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }
}
