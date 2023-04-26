// Lutemon App, LutemonStatisticsActivity
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Statistics activity that contains the training days, experience, wins and losses for the lutemons
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class LutemonStatisticsActivity extends AppCompatActivity {

    private ArrayList<Lutemon> listOfLutemons = new ArrayList<>();

    private RecyclerView recyclerView;

    private LutemonStatisticsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_statistics);
        listOfLutemons.addAll(HomeArea.getInstance().getLutemons());
        listOfLutemons.addAll(BattleArea.getInstance().getLutemons());
        listOfLutemons.addAll(TrainingArea.getInstance().getLutemons());
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonStatisticsAdapter(getApplicationContext(), listOfLutemons);
        recyclerView.setAdapter(adapter);
    }

    // Method for switching to the visualized diagram activity
    public void switchToLutemonDiagram (View view){
        Intent intent = new Intent(this, LutemonDiagramActivity.class);
        startActivity(intent);
    }
}