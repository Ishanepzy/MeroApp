package com.example.mobileprogramming.unit_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobileprogramming.R;

public class TextFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle b){
        return inflater.inflate(R.layout.hello_text, container, false);
    }
}
