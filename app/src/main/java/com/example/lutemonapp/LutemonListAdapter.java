package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(ArrayList<Lutemon> lutemons, Context context){
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position){
        holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonHealth.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth()));
        holder.lutemonExp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
