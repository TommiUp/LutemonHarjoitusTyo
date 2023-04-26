// Lutemon App, LutemonMoveActivity
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Activity for moving lutemons to training, battle and home by selecting them and moving with a single button
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LutemonMoveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RadioGroup rgMove;
    private RadioButton rbHome, rbTraining, rbCombat;
    private ArrayList<Lutemon> listOfLutemons = new ArrayList<>();
    // Works as a helper variable that is used to find lutemons from different places
    // such as battle, home, training

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_move);
        recyclerView = findViewById(R.id.rvLutemonList);
        listOfLutemons.addAll(HomeArea.getInstance().getLutemons());
        listOfLutemons.addAll(BattleArea.getInstance().getLutemons());
        listOfLutemons.addAll(TrainingArea.getInstance().getLutemons());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonMoveAdapter(getApplicationContext(), listOfLutemons));
        rgMove = findViewById(R.id.rgMove);
        rbHome = findViewById(R.id.rbHome);
        rbTraining = findViewById(R.id.rbTraining);
        rbCombat = findViewById(R.id.rbCombat);
        for (Lutemon lutemon: listOfLutemons) {
            lutemon.setChecked(false);
        }
    }

    // Method for moving lutemons to different activities such ass battlefield, training area and home
    public void moveLutemons(View view) {
        switch (rgMove.getCheckedRadioButtonId()) {
            case R.id.rbHome:
                System.out.println("Kotiin nappia painettu");
                sendToHome();
                break;
            case R.id.rbTraining:
                System.out.println("Training nappia painettu");
                sendToTraining();
                break;
            case R.id.rbCombat:
                System.out.println("Battle nappia painettu");
                sendToBattle();
                break;
        }
    }

    // Method for sending lutemons to home (arraylist)
    public void sendToHome() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : listOfLutemons) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            lutemon.setMaxHealth();
            if (!HomeArea.getInstance().getLutemons().contains(lutemon)) {
                BattleArea.getInstance().removeLutemon(lutemon);
                TrainingArea.getInstance().removeLutemon(lutemon);
                HomeArea.getInstance().addLutemon(lutemon);
                }
            }
        HomeArea.getInstance().saveLutemons(getApplicationContext());
    }

    // Method for sending lutemons to training area (arraylist)
    public void sendToTraining() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : listOfLutemons) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            if (!TrainingArea.getInstance().getLutemons().contains(lutemon)) {
                HomeArea.getInstance().removeLutemon(lutemon);
                BattleArea.getInstance().removeLutemon(lutemon);
                TrainingArea.getInstance().addLutemon(lutemon);
            }
        }
        TrainingArea.getInstance().saveLutemons(getApplicationContext());
    }

    // Method for sending lutemons to battlefield (arraylist)
    public void sendToBattle() {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : listOfLutemons) {
            if (lutemon.isChecked()) {
                checkedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : checkedLutemons) {
            if (!BattleArea.getInstance().getLutemons().contains(lutemon)) {
                HomeArea.getInstance().removeLutemon(lutemon);
                TrainingArea.getInstance().removeLutemon(lutemon);
                BattleArea.getInstance().addLutemon(lutemon);
            }
        }
        BattleArea.getInstance().saveLutemons(getApplicationContext());
    }
}