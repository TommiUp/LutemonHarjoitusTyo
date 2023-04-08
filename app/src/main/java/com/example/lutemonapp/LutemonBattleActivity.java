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
        adapter = new LutemonBattleAdapter(getApplicationContext(), storage.getLutemons("battle"));
        recyclerView.setAdapter(adapter);
        txtBattle = findViewById(R.id.txtBattleInfo);
        for (Lutemon lutemon : storage.getLutemons("battle")) {
            lutemon.setChecked(false);
        }
    }


    public void sendToBattle(View view) {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("battle")) {
            if (lutemon.isChecked() && (checkedLutemons.size() < 2)) {
                checkedLutemons.add(lutemon);
            }
        }
        if (checkedLutemons.size() == 2) {
            StringBuilder battleInfo = new StringBuilder();
            Lutemon attacker = checkedLutemons.get(0);
            Lutemon defender = checkedLutemons.get(1);
            boolean battleOver = false;
            while (!battleOver) {
                // Attacker attacks defender
                int damage = attacker.attack() - defender.defence();
                if (damage > 0) {
                    defender.takeDamage(damage);
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            attacker.getId(), attacker.getName(), attacker.attack(), attacker.defence(), attacker.getExperience(),
                            attacker.getHealth(), attacker.getMaxHealth()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            defender.getId(), defender.getName(), defender.attack(), defender.defence(), defender.getExperience(),
                            defender.getHealth(), defender.getMaxHealth()));
                    battleInfo.append(String.format("%s attacks %s\n", attacker.getName(), defender.getName()));
                    if (defender.getHealth() == 0) {
                        battleInfo.append(String.format("%s gets killed.\nThe battle is over.", defender.getName()));
                        storage.removeLutemon(defender, "battle");
                        storage.removeLutemon(defender, "all");
                        attacker.gainExperience();
                        battleOver = true;
                        break;
                    }
                } else {
                    battleInfo.append(String.format("%s attacks %s\n", attacker.getName(), defender.getName()));
                }
                // Defender attacks attacker
                damage = defender.attack() - attacker.defence();
                if (damage > 0) {
                    attacker.takeDamage(damage);
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            defender.getId(), defender.getName(), defender.attack(), defender.defence(), defender.getExperience(),
                            defender.getHealth(), defender.getMaxHealth()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            attacker.getId(), attacker.getName(), attacker.attack(), attacker.defence(), attacker.getExperience(),
                            attacker.getHealth(), attacker.getMaxHealth()));
                    battleInfo.append(String.format("%s attacks %s\n", defender.getName(), attacker.getName()));
                    if (attacker.getHealth() == 0) {
                        battleInfo.append(String.format("%s gets killed.\nThe battle is over.", attacker.getName()));
                        storage.removeLutemon(attacker, "battle");
                        storage.removeLutemon(attacker, "all");
                        defender.gainExperience();
                        battleOver = true;
                        break;
                    }
                } else {
                    battleInfo.append(String.format("%s attacks %s\n", defender.getName(), attacker.getName()));
                }
            }
            txtBattle.setText(battleInfo.toString());
        }
        storage.saveLutemons(getApplicationContext());
        adapter.notifyDataSetChanged();
        for (Lutemon lutemon : storage.getLutemons("battle")) {
            lutemon.setChecked(false);
        }
    }
}