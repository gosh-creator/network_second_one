package com.example.network.users;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.network.R;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    CircleImageView profileImage;
    TextView username_tv;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        profileImage = itemView.findViewById(R.id.profile_iv);
        username_tv = itemView.findViewById(R.id.username_tv);
    }
}
