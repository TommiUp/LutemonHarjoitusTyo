package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonListViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonListViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonListViewHolder holder, int position){
        holder.imgLutemon.setImageResource(lutemons.get(position).getImg());
        holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.lutemonHealth.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth()));
        holder.lutemonExp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
        holder.editName.setText(lutemons.get(position).getName());
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                removeLutemon(lutemons.get(pos));
                LutemonStorage.getInstance().saveLutemons(context);
                LutemonStorage.getInstance().loadLutemons(context);
            }
        });
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (holder.editName.getVisibility() == view.VISIBLE){
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemonByIdWithoutRemove(pos);
                    lutemon.setName(holder.editName.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                    LutemonStorage.getInstance().saveLutemons(context);
                    LutemonStorage.getInstance().loadLutemons(context);
                } else {
                    holder.editName.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void removeLutemon(Lutemon lutemon) {
        int position = lutemons.indexOf(lutemon);
        if (position != -1) {
            lutemons.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void setLutemons(ArrayList<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
