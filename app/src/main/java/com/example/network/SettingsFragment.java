package com.example.network;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.network.Profile.Fragment_profile;
import com.example.network.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding settingsBinding;

    public String txt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        settingsBinding = FragmentSettingsBinding.inflate(inflater, container, false);

        settingsBinding.etBio.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (event!=null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    txt = settingsBinding.etBio.getText().toString();
                    Intent i = new Intent(getContext(), Fragment_profile.class);
                    i.putExtra("et", txt);
                    startActivity(i);
                    return true;
                }else{
                    Toast.makeText(getContext(), "something wrong", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });


        return settingsBinding.getRoot();
    }
}