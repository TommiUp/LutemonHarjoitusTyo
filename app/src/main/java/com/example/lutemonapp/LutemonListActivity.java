package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Collections;

public class LutemonListActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView  recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_list);

        storage = LutemonStorage.getInstance();

        recyclerView = findViewById(R.id.rvLutemonList);

        Collections.sort(LutemonStorage.getInstance().getLutemons(), (lutemon1, lutemon2) -> lutemon1.getName().compareTo(lutemon2.getName()));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(storage.getLutemons(), getApplicationContext()));
    }
}