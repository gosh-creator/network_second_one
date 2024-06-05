package com.example.network.Log_Reg_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.network.The_Main.MainOne;
import com.example.network.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    public ActivityMainBinding login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        login = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(login.getRoot());

        login.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.emailEt.getText().toString().isEmpty() || login.passwordEt.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "the fields should not be an empty)", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, Registration.class));
                }else {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(login.emailEt.getText().toString(), login.passwordEt.getText().toString())
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(Login.this, MainOne.class));
                            }
                        }
                    });
                }
            }
        });

        login.goToRegisterActivityTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Registration.class));
            }
        });
    }
}