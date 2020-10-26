package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDatabaseHelper;
    ArrayList<String> info_id, info_title, info_topic, info_page;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDatabaseHelper = new MyDatabaseHelper(MainActivity3.this);
        info_id = new ArrayList<>();
        info_title = new ArrayList<>();
        info_topic = new ArrayList<>();
        info_page = new ArrayList<>();

        displayData();

        customAdapter = new CustomAdapter(MainActivity3.this, info_id, info_title, info_topic, info_page);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));
    }

    void displayData(){
        Cursor cursor = myDatabaseHelper.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No Data Appears", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                info_id.add(cursor.getString(0));
                info_title.add(cursor.getString(1));
                info_topic.add(cursor.getString(2));
                info_page.add(cursor.getString(3));
            }
        }
    }
}