package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;

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
}