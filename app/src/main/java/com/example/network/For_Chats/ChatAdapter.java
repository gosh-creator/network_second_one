package com.example.network.For_Chats;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.network.ChatActivity;
import com.example.network.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

    private ArrayList<Chat> chats;

    public ChatAdapter(ArrayList<Chat> chats){
        this.chats = chats;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item_rv, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.chatname_tv.setText(chats.get(position).getChat_name());
        String userid;
        if (!chats.get(position).getUserId1().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
            userid = chats.get(position).getUserId1();
        }else{
            userid = chats.get(position).getUserId2();
        }

        FirebaseDatabase.getInstance().getReference().child("Users").child(userid)
                .child("profileImage").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        try {
                            String profileImageUrl = task.getResult().getValue().toString();

                            if (!profileImageUrl.isEmpty())
                                Glide.with(holder.itemView.getContext()).load(profileImageUrl).into(holder.chat_iv);
                        }catch (Exception e){
                            Toast.makeText(holder.itemView.getContext(), "smth went wrong(", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        holder.itemView.setOnClickListener (v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ChatActivity.class);
            intent.putExtra("chatId", chats.get(position).getChatid());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
}
