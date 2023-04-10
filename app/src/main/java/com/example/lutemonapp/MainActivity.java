package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, LutemonAddActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemon(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemon(View view) {
        Intent intent = new Intent(this, LutemonMoveActivity.class);
        startActivity(intent);
    }

    public void switchToTrainingLutemon(View view) {
        Intent intent = new Intent(this, LutemonTrainingActivity.class);
        startActivity(intent);
    }

    public void switchToBattleLutemon(View view) {
        Intent intent = new Intent(this, LutemonBattleActivity.class);
        startActivity(intent);
    }

    public void switchToStatLutemon(View view) {
        Intent intent = new Intent(this, LutemonStatisticsActivity.class);
        startActivity(intent);
    }
}