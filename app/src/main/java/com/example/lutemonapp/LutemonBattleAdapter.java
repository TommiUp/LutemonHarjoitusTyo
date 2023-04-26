// Lutemon App, LutemonBattleAdapter
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Adapter for the battle screen recycler view
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonBattleAdapter extends RecyclerView.Adapter<LutemonBattleViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonBattleAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }
    @NonNull
    @Override
    public LutemonBattleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonBattleViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_battle_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonBattleViewHolder holder, int position){
        Lutemon lutemon = lutemons.get(position);
        holder.checkboxBattle.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.checkboxBattle.setChecked(lutemon.isChecked());
        holder.checkboxBattle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lutemon.setChecked(isChecked);
        });
    }

    // Method for telling the size of the list
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

