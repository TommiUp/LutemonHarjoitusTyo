package com.example.lutemonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class LutemonMoveActivity extends AppCompatActivity {

    private LutemonStorage storage;

    private RecyclerView recyclerView;
    private RadioGroup rgMove;
    private RadioButton rbHome, rbTraining, rbCombat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_move);
        storage = LutemonStorage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonMoveAdapter(getApplicationContext(), storage.getLutemons()));
        rgMove = findViewById(R.id.rgMove);
        rbHome = findViewById(R.id.rbHome);
        rbTraining = findViewById(R.id.rbTraining);
        rbCombat = findViewById(R.id.rbCombat);
    }

    public void moveLutemons(View view) {
        switch (rgMove.getCheckedRadioButtonId()) {
            case R.id.rbHome:
                System.out.println("Kotiin nappia painettu");
                sendToHome();
                break;
            case R.id.rbTraining:
                System.out.println("Training nappia painettu");
                trainLutemons();
                break;
            case R.id.rbCombat:
                System.out.println("Battle nappia painettu");
                battleLutemons();
                break;
        }
    }

    public void sendToHome() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons()) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.makeInvisible();
            lutemon.setMaxHealth();
        }
        storage.saveLutemons(getApplicationContext());
    }

    public void trainLutemons() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons()) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.gainExperience();
        }
        storage.saveLutemons(getApplicationContext());
    }

    public void battleLutemons() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons()) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.makeVisible();
        }
        storage.saveLutemons(getApplicationContext());
    }
}