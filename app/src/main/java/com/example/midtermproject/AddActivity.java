package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText input_title, input_meaning, pages_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        input_title = findViewById(R.id.input_title);
        input_meaning = findViewById(R.id.input_meaning);
        pages_input = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(AddActivity.this);
                myDatabaseHelper.AddInfo(input_title.getText().toString().trim(),
                        input_meaning.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));
            }
        });
    }
}