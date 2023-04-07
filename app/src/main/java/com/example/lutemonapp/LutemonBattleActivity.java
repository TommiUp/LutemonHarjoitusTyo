package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LutemonBattleActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView recyclerView;

    private LutemonBattleAdapter adapter;

    private TextView txtBattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_battle);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonBattleAdapter(getApplicationContext(), storage.getLutemons());
        recyclerView.setAdapter(adapter);
        txtBattle = findViewById(R.id.txtBattleInfo);
        for (Lutemon lutemon : storage.getLutemons()) {
            lutemon.setChecked(false);
        }
    }


    public void sendToBattle(View view) {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons()) {
            if (lutemon.isChecked() && (checkedLutemons.size() < 2)) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.fight(checkedLutemons.get(0), checkedLutemons.get(1));
            txtBattle.setText(lutemon.toString());
        }
        storage.saveLutemons(getApplicationContext());
        adapter.notifyDataSetChanged();
    }
}