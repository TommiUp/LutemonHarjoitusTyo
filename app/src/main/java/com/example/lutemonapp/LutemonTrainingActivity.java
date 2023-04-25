package com.example.lutemonapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LutemonTrainingActivity extends AppCompatActivity {

    private TrainingArea trainingArea;

    private RecyclerView recyclerView;

    private LutemonTrainingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_training);
        trainingArea = TrainingArea.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonTrainingAdapter(getApplicationContext(), trainingArea.getLutemons());
        recyclerView.setAdapter(adapter);
        for (Lutemon lutemon : trainingArea.getLutemons()) {
            lutemon.setChecked(false);
        }
    }

    // Method for training lutemons. Increases experience and health
    public void trainLutemons(View view) {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : trainingArea.getLutemons()) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.gainExperience();
            lutemon.increaseTrainingDays();
        }
        trainingArea.saveLutemons(getApplicationContext());
        adapter.notifyDataSetChanged();
    }
}