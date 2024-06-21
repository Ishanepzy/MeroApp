package com.example.mobileprogramming.unit_4;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);

        Resources res = getResources();

        Spinner countrySpinner = findViewById(R.id.countrySpinner);

        String[] countryList = {"Nepal", "Korea", "Netherlands", "United Kingdom", "Germany"};

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, countryList);
        countrySpinner.setAdapter(countryAdapter);

        TextView fullName = findViewById(R.id.headingText);
        Button submitButton = findViewById(R.id.submit_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        TextView fullNameText = findViewById(R.id.fullNameValue);

        CheckBox footballCheckbox = findViewById(R.id.checkboxFootball);
        CheckBox basketballCheckbox = findViewById(R.id.checkboxBasketball);
        CheckBox volleyballCheckbox = findViewById(R.id.checkboxVolleyball);
        CheckBox badmintonCheckbox = findViewById(R.id.checkboxBadminton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Home.this, About.class);
                startActivity(intent);

                String fullName = fullNameText.getText().toString();

                int checkedRadioButtonId = genderGroup.getCheckedRadioButtonId();

                ArrayList<String> selectedSports = new ArrayList<>();

                String fullNameText = "";
                if (fullName != null && !fullName.isEmpty()) fullNameText = fullName;
                else fullNameText = res.getString(R.string.anonymous);

                String selectedGender = "unknown";
                if (checkedRadioButtonId == R.id.genderMale)
                    selectedGender = "male";
                else if (checkedRadioButtonId == R.id.genderFemale)
                    selectedGender = "female";

                CheckBox[] checkBoxes = {footballCheckbox, basketballCheckbox, volleyballCheckbox, badmintonCheckbox};

                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) selectedSports.add(checkBox.getText().toString());
                }

                Intent i = new Intent(Home.this, About.class);

                i.putExtra("fullName", fullNameText);
                i.putExtra("gender", selectedGender);
                i.putExtra("country", "Nepal");
                i.putStringArrayListExtra("sports", selectedSports);

               startActivity(i);
               startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 20){
            Log.d("requestCode","200");
            if(resultCode == 200){

                if(data!=null){
                    String result = data.getStringExtra("data");
                    //View.setText(result);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(requestCode == 20){
            if(resultCode == 201){
                if(data!=null){
                    //View.setText("");
                    Toast.makeText(getApplicationContext(), " ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myStatelog", "Home - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myStatelog", "Home - onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myStatelog", "Home - onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myStatelog", "Home - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myStatelog", "Home - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myStatelog", "Home - onStop");
    }

}