package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonTrainingAdapter extends RecyclerView.Adapter<LutemonTrainingViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonTrainingAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonTrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonTrainingViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_train_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonTrainingViewHolder holder, int position){
        Lutemon lutemon = lutemons.get(position);
        holder.checkboxTrain.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.txtAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.txtDefence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.txtHealth.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth()));
        holder.txtExp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.checkboxTrain.setChecked(lutemon.isChecked());
        holder.checkboxTrain.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lutemon.setChecked(isChecked);
        });
    }

    // Method for telling the size of the list
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

