package com.example.mobileprogramming.unit_4;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.util.ArrayList;

public class About extends AppCompatActivity {
    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Resources res = getResources();

        TextView TextView = findViewById(R.id.aboutFullNameValue);
        TextView Gender = findViewById(R.id.aboutGenderValue);
        TextView Country = findViewById(R.id.aboutCountryValue);
        TextView Sports = findViewById(R.id.aboutSportsValue);

        Intent i = getIntent();
        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");
        String fullName = i.getStringExtra("fullName");
        ArrayList<String> sports = i.getStringArrayListExtra("sports");

        TextView.setText(fullName);
        Gender.setText(gender);
        Country.setText(country);
        Sports.setText(sports.toString());

        if (sports != null && !sports.isEmpty()) {
            String joinedSports = String.join(", ", sports);
            Sports.setText(joinedSports);
        } else {
            Toast.makeText(getApplicationContext(), "No sports found", Toast.LENGTH_SHORT).show();
            Sports.setText(res.getString(R.string.na));
        }

        Button backButton = findViewById(R.id.aboutBackButton);

        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button activityDialogButton = findViewById(R.id.aboutDialogButton);

        activityDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data", "Hello World");
                setResult(200, i);
                finish();
            }
        });
    }
}
