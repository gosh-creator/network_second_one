package com.example.network.The_Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.network.Profile.Fragment_profile;
import com.example.network.databinding.SettingsBinding;

public class Settings extends AppCompatActivity {

    public static String txt;

    public SettingsBinding settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = SettingsBinding.inflate(getLayoutInflater());
        setContentView(settings.getRoot());

        settings.etBio.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    txt = settings.etBio.getText().toString();
                    ///
                    Intent i = new Intent(Settings.this, Fragment_profile.class);
                    i.putExtra("et", txt);
                    startActivity(i);
                    ///
                    return true;
                }else{
                    Toast.makeText(Settings.this, "Smth went wrong", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }
}