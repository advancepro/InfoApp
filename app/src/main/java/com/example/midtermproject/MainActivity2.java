package com.example.midtermproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24,
            R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24,
            R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24, R.drawable.ic_baseline_bubble_chart_24};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}