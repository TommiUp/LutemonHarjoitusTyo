package com.example.lutemonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method that switches to the Lutemon creation activity
    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, LutemonAddActivity.class);
        startActivity(intent);
    }

    // Method that switches to the Lutemon home (list) activity
    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    // Method that switches to the Lutemon move activity
    public void switchToMoveLutemon(View view) {
        Intent intent = new Intent(this, LutemonMoveActivity.class);
        startActivity(intent);
    }

    // Method that switches to the Lutemon training activity
    public void switchToTrainingLutemon(View view) {
        Intent intent = new Intent(this, LutemonTrainingActivity.class);
        startActivity(intent);
    }

    // Method that switches to the Lutemon battle activity
    public void switchToBattleLutemon(View view) {
        Intent intent = new Intent(this, LutemonBattleActivity.class);
        startActivity(intent);
    }

    // Method that switches to the Lutemon statistics activity
    public void switchToStatLutemon(View view) {
        Intent intent = new Intent(this, LutemonStatisticsActivity.class);
        startActivity(intent);
    }
}