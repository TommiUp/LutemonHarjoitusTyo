package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LutemonStatisticsActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView recyclerView;

    private LutemonStatisticsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_statistics);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonStatisticsAdapter(getApplicationContext(), storage.getLutemons("all"));
        recyclerView.setAdapter(adapter);
    }
}