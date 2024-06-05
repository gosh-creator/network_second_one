package com.example.network.Log_Reg_in;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.network.The_Main.MainOne;
import com.example.network.databinding.ActivityRegistration2Binding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration extends AppCompatActivity {

    public ActivityRegistration2Binding register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        register = ActivityRegistration2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(register.getRoot());

        register.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (register.emailEt.getText().toString().isEmpty() || register.passwordEt.getText().toString().isEmpty() || register.usernameEt.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Fields must not be empty", Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(register.emailEt.getText().toString(), register.passwordEt.getText().toString()).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        HashMap<String, String> userInfo = new HashMap<>();
                                        userInfo.put("email", register.emailEt.getText().toString());
                                        userInfo.put("password", register.passwordEt.getText().toString());
                                        userInfo.put("username", register.usernameEt.getText().toString());
                                        userInfo.put("profileImage", "https://pngicon.ru/file/uploads/mario-900x1118.png");
                                        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);
                                        userInfo.put("chats", FirebaseAuth.getInstance().getCurrentUser().getUid());
                                        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userInfo);

//                                        HashMap<String, String> ChatsId = new HashMap<>();
//                                        ChatsId.put("userId1", Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getUid()).toString());
//                                        ChatsId.put("userId2", "");
//                                        FirebaseDatabase.getInstance().getReference().child("ChatsId").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).setValue(ChatsId);
                                        startActivity(new Intent(Registration.this, MainOne.class));
                                    }
                                }
                            });
                }
            }
        });

        register.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

    }
}