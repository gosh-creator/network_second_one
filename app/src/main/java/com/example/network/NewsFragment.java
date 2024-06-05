package com.example.network;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.network.databinding.FragmentNewsBinding;
import com.example.network.news.News;
import com.example.network.news.NewsAdapter;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding fragmentNewsBinding;
    private ArrayList<News> newsArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNewsBinding = FragmentNewsBinding.inflate(inflater, container, false);
        fragmentNewsBinding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentNewsBinding.rvNews.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        fragmentNewsBinding.rvNews.setAdapter(new NewsAdapter(newsArrayList));
        return fragmentNewsBinding.getRoot().getRootView();
    }
}