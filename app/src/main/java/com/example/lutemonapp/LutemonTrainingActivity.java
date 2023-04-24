package com.example.lutemonapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LutemonTrainingActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView recyclerView;

    private LutemonTrainingAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_training);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonTrainingAdapter(getApplicationContext(), storage.getLutemons("training"));
        recyclerView.setAdapter(adapter);
        for (Lutemon lutemon : storage.getLutemons("training")) {
            lutemon.setChecked(false);
        }
    }

    // Method for training lutemons. Increases experience and health
    public void trainLutemons(View view) {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("training")) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.gainExperience();
            lutemon.increaseTrainingDays();
        }
        storage.saveLutemons(getApplicationContext());
        adapter.notifyDataSetChanged();
    }
}