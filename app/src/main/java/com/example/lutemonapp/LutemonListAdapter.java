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
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent,false)); //lutemon view varten tarvitaan xml file//

    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position){
        holder.LutemonNimi.setText(lutemons.get(position).getName() + " " + lutemons.get(position).getColor());
        holder.LutemonHyokkays.setText();
    }


}
