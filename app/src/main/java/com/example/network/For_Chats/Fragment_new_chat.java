package com.example.network.For_Chats;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.network.databinding.FragmentNewChatBinding;
import com.example.network.users.User;
import com.example.network.users.UsersAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Fragment_new_chat extends Fragment {
    public FragmentNewChatBinding newchat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        newchat = FragmentNewChatBinding.inflate(inflater, container, false);
        loadUsers();
        return newchat.getRoot();
    }

    private void loadUsers(){
        ArrayList<User> users = new ArrayList<User>();
        FirebaseDatabase.getInstance().getReference().child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot userSnapshot : snapshot.getChildren()){
                    if (userSnapshot.getKey().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
                        continue;
                    }

                    String uid = userSnapshot.getKey();
                    String username = userSnapshot.child("username").getValue().toString();
                    String profileImage = userSnapshot.child("profileImage").getValue().toString();

                    users.add(new User(uid, username, profileImage));
                }

                newchat.usersRv.setLayoutManager(new LinearLayoutManager(getContext()));
                newchat.usersRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                newchat.usersRv.setAdapter(new UsersAdapter(users));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}