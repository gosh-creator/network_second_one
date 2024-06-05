package com.example.network.For_Chats;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.network.R;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    CircleImageView chat_iv;
    TextView chatname_tv;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);

        chat_iv = itemView.findViewById(R.id.profile_iv);
        chatname_tv = itemView.findViewById(R.id.username_tv);
    }
}
