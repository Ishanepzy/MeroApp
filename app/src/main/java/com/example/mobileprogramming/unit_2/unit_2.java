package com.example.mobileprogramming.unit_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobileprogramming.R;

public class unit_2 extends AppCompatActivity {

    public Button submit;
    public Button cancel;
    public TextView headingText;
    public EditText editText;

    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.unit2);
        handleEvents();

    }
    public void handleEvents(){
        submit = findViewById(R.id.submit_button);
        cancel = findViewById(R.id.cancel_button);
        headingText = findViewById(R.id.headingText);
        editText = findViewById(R.id.editText);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String input = editText.getText().toString();
                headingText.setText(input);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String input = editText.getText().toString();
                headingText.setText(null);
                editText.setText(null);
            }
        });
    }
}
