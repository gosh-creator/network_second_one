package com.example.network.For_Chats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.network.databinding.FragmentMenuChatsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Fragment_menu_chats extends Fragment {

    public FragmentMenuChatsBinding chat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        chat = FragmentMenuChatsBinding.inflate(inflater, container, false);
        loadChats();
        return chat.getRoot();
    }


    private void loadChats(){
        ArrayList<Chat> chats = new ArrayList<>();
        String uid = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid();
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String ChatsStr = Objects.requireNonNull(snapshot.child("Users").child(uid).child("chats").getValue()).toString();
                String[] ChatIds = ChatsStr.split(",");

                for (String chatId : ChatIds) {
                    DataSnapshot chatSnapshot = snapshot.child("ChatsId").child(chatId);

                    String userId1 = Objects.requireNonNull(chatSnapshot.child("userId1").getValue()).toString();
                    String userId2 = Objects.requireNonNull(chatSnapshot.child("userId2").getValue()).toString();

                    String chatuserId;
                    if (uid.equals(userId1)){
                        chatuserId = userId2;
                    }else{
                        chatuserId = userId1;
                    }

                    String chatName = Objects.requireNonNull(snapshot.child("Users").child(chatuserId).child("username").getValue()).toString();

                    Chat chat = new Chat(chatId, chatName, userId1, userId2);
                    chats.add(chat);
                }

                chat.usersRv.setLayoutManager(new LinearLayoutManager(getContext()));
                chat.usersRv.setAdapter(new ChatAdapter(chats));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failed to get users chats ( ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}