package com.example.network.The_Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.network.For_Chats.Fragment_menu_chats;
import com.example.network.For_Chats.Fragment_new_chat;
import com.example.network.NewsFragment;
import com.example.network.Profile.Fragment_profile;
import com.example.network.R;
import com.example.network.databinding.ActivityMainOneBinding;

import java.util.HashMap;
import java.util.Map;

public class MainOne extends AppCompatActivity {

    public ActivityMainOneBinding main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        main = ActivityMainOneBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(main.getRoot());

        getSupportFragmentManager().beginTransaction().replace(main.fragmentContainer.getId(), new Fragment_menu_chats()).commit();


        main.bottomNavigationView.setSelectedItemId(R.id.chats);

        Map<Integer, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(R.id.chats, new Fragment_menu_chats());
        fragmentMap.put(R.id.profile, new Fragment_profile());
        fragmentMap.put(R.id.new_chat, new Fragment_new_chat());
        fragmentMap.put(R.id.feed, new NewsFragment());

        main.bottomNavigationView.setSelectedItemId(R.id.new_chat);

        main.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment = fragmentMap.get(item.getItemId());

            getSupportFragmentManager().beginTransaction().replace(main.fragmentContainer.getId(), fragment).commit();

            return true;

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("!!!!!");
    }
}