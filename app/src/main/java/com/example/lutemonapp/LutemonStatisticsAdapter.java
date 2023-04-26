// Lutemon App, LutemonStatisticsAdapter
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Adapter for the statistics recycler view
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonStatisticsAdapter extends RecyclerView.Adapter<LutemonStatisticsViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonStatisticsAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonStatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonStatisticsViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_stat_view, parent,false)); // lutemon view varten tarvitaan xml file
    }
    @Override
    public void onBindViewHolder(@NonNull LutemonStatisticsViewHolder holder, int position){
        holder.imgLutemon.setImageResource(lutemons.get(position).getImg());
        holder.txtName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.txtExp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.txtWin.setText("Voitot: " + String.valueOf(lutemons.get(position).getWins()));
        holder.txtLost.setText("Häviöt: " + String.valueOf(lutemons.get(position).getLost()));
        holder.txtDays.setText("Treenipäivät: " + String.valueOf(lutemons.get(position).getTrainingDays()));
    }

    // Method for telling the size of the list
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

