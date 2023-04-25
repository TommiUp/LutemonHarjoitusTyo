package com.example.lutemonapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListActivity extends AppCompatActivity {
    private HomeArea homeArea;
    private Context context;
    private RecyclerView  recyclerView;
    private LutemonListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_list);
        homeArea = HomeArea.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonListAdapter(getApplicationContext(), homeArea.getLutemons());
        recyclerView.setAdapter(adapter);
        context = this;
    }

    // Method for loading the save file
    public void loadLutemonFile(View view){
        homeArea.loadLutemons(context);
        adapter.setLutemons(homeArea.getLutemons());
        adapter.notifyDataSetChanged();
    }

    // Method for saving the save file
    public void saveLutemonFile(View view){
        homeArea.saveLutemons(context);
        adapter.notifyDataSetChanged();
    }
}
