package com.example.mobileprogramming.unit_5;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobileprogramming.R;

public class FragmentSwitchActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit_5_fragment_switch);

        FragmentManager fe = getSupportFragmentManager();
        int fragmentContainerId = R.id.fragmentSwitchButtomContainer;
        Button fragmentOneButton = findViewById(R.id.moonfrag);
        Button fragmentTwoButton = findViewById(R.id.sunfrag);
        Button fragmentCrossButtton = findViewById(R.id.back);

        fragmentOneButton.setOnClickListener(v ->{
            Fragment ImageFragment = new imageFragment();

            FragmentTransaction ft = fe.beginTransaction();
            ft.replace(fragmentContainerId,ImageFragment);
            ft.addToBackStack(null);
            ft.commit();
        });

        fragmentTwoButton.setOnClickListener(v ->{
            Fragment myLogoFragment = new MyLogoFragment();

            FragmentTransaction ft = fe.beginTransaction();
            ft.replace(fragmentContainerId,myLogoFragment);
            ft.addToBackStack(null);
            ft.commit();
        });

        fragmentCrossButtton.setOnClickListener(v -> {
            fe.popBackStack();
        });
    }
}
