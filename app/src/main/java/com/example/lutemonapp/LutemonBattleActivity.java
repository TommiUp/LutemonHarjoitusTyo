package com.example.lutemonapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LutemonBattleActivity extends AppCompatActivity {
    private BattleArea battleArea;

    private RecyclerView recyclerView;

    private LutemonBattleAdapter adapter;

    private TextView txtBattle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lutemon_battle);
        battleArea = BattleArea.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LutemonBattleAdapter(getApplicationContext(), battleArea.getLutemons());
        recyclerView.setAdapter(adapter);
        txtBattle = findViewById(R.id.txtBattleInfo);
        for (Lutemon lutemon : battleArea.getLutemons()) {
            lutemon.setChecked(false);
        }
    }

    // Method for starting the battle and showing the battle info in a TextView
    public void battleLutemons(View view) {
        List<Lutemon> checkedLutemons = new ArrayList<>();
        for (Lutemon lutemon : battleArea.getLutemons()) {
            if (lutemon.isChecked() && (checkedLutemons.size() < 2)) {
                checkedLutemons.add(lutemon);
            }
        }
        if (checkedLutemons.size() == 2) {
            StringBuilder battleInfo = new StringBuilder();
            // Show stats of the lutemons before the battle
            for (Lutemon lutemon : checkedLutemons) {
                battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                        lutemon.getId(), lutemon.getName(), lutemon.attack(), lutemon.defence(), lutemon.getExperience(),
                        lutemon.getHealth(), lutemon.getMaxHealth()));
            }
            Lutemon attacker = checkedLutemons.get(0);
            Lutemon defender = checkedLutemons.get(1);
            boolean battleOver = false;
            while (!battleOver) {
                // Attacker attacks defender
                int damage = attacker.attack() - defender.defence() + (int)(Math.random() * 4);
                if (damage > 0) {
                    defender.takeDamage(damage);
                    battleInfo.append(String.format("%s attacks %s\n", attacker.getName(), defender.getName()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            attacker.getId(), attacker.getName(), attacker.attack(), attacker.defence(), attacker.getExperience(),
                            attacker.getHealth(), attacker.getMaxHealth()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            defender.getId(), defender.getName(), defender.attack(), defender.defence(), defender.getExperience(),
                            defender.getHealth(), defender.getMaxHealth()));
                    if (defender.getHealth() == 0) {
                        battleInfo.append(String.format("%s gets defeated.\nThe battle is over.", defender.getName()));
                        attacker.increaseVictory();
                        defender.increaseDefeat();
                        attacker.gainExperience();
                        battleOver = true;
                        break;
                    }
                } else {
                    battleInfo.append(String.format("%s attacks %s\n", attacker.getName(), defender.getName()));
                }
                // Defender attacks attacker
                damage = defender.attack() - attacker.defence() + (int)(Math.random() * 4);
                if (damage > 0) {
                    attacker.takeDamage(damage);
                    battleInfo.append(String.format("%s attacks %s\n", defender.getName(), attacker.getName()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            attacker.getId(), attacker.getName(), attacker.attack(), attacker.defence(), attacker.getExperience(),
                            attacker.getHealth(), attacker.getMaxHealth()));
                    battleInfo.append(String.format("%d: %s att: %d; def: %d; exp:%d; health:%d/%d\n",
                            defender.getId(), defender.getName(), defender.attack(), defender.defence(), defender.getExperience(),
                            defender.getHealth(), defender.getMaxHealth()));
                    if (attacker.getHealth() == 0) {
                        battleInfo.append(String.format("%s gets defeated.\nThe battle is over.", attacker.getName()));
                        defender.increaseVictory();
                        attacker.increaseDefeat();
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
        battleArea.saveLutemons(getApplicationContext());
        adapter.notifyDataSetChanged();
        for (Lutemon lutemon : battleArea.getLutemons()) {
            lutemon.setChecked(false);
        }
    }
}