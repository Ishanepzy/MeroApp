package com.example.mobileprogramming.unit_3;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.unit_4.About;

public class Hello extends Activity {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.constraint_layout);

        Log.d("myStatelog", "Home - onCreate");

        Button cancelButton = findViewById(R.id.cancel_button);
        //Button submitButton = findViewById(R.id.submit_button);
        Spinner countrySpinner = findViewById(R.id.countrySpinner);

        String[] countryList = {"Korea", "Netherlands", "United Kingdom", "Germany"};

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, countryList);
        countrySpinner.setAdapter(countryAdapter);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();

            }
        });

    }
}