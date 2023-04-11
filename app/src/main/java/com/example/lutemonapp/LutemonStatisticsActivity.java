package com.example.lutemonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



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



        public void switchToLutemonDiagram (View view){
            Intent intent = new Intent(this, LutemonDiagramActivity.class);
            startActivity(intent);
        }
    }