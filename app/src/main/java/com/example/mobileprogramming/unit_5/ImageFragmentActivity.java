package com.example.mobileprogramming.unit_5;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.mobileprogramming.R;

public class ImageFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle b) {
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.dark_purple));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.light_purple));

        super.onCreate(b);
        setContentView(R.layout.unit_5_image_fragment);
    }
}
