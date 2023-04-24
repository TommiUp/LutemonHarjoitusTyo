package com.example.lutemonapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListActivity extends AppCompatActivity {
    private LutemonStorage storage;
    private Context context;
    private RecyclerView  recyclerView;
    private LutemonListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_list);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonListAdapter(getApplicationContext(), storage.getLutemons("home"));
        recyclerView.setAdapter(adapter);
        context = this;
    }

    // Method for loading the save file
    public void loadLutemonFile(View view){
        storage.loadLutemons(context);
        adapter.setLutemons(storage.getLutemons("home"));
        adapter.notifyDataSetChanged();
    }

    // Method for saving the save file
    public void saveLutemonFile(View view){
        storage.saveLutemons(context);
        adapter.notifyDataSetChanged();
    }
}
