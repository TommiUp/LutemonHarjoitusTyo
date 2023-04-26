// Lutemon App, LutemonMoveAdapter
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Adapter for the recycler view that contains lutemons that can be moved to different areas
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonMoveAdapter extends RecyclerView.Adapter<LutemonMoveViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonMoveAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonMoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonMoveViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_move_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonMoveViewHolder holder, int position){
        Lutemon lutemon = lutemons.get(position);
        holder.checkboxName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.checkboxName.setChecked(lutemon.isChecked());
        holder.checkboxName.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lutemon.setChecked(isChecked);
        });
    }

    // Method for telling the size of the list
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
