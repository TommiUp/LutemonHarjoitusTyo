package com.example.lutemonapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {

    private Context context;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent,false)); // lutemon view varten tarvitaan xml file
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position){
        Lutemon lutemon = lutemons.get(position);
        if (lutemon.getBattleStatus() == 0){
            holder.lutemonName.setVisibility(View.VISIBLE);
            holder.lutemonAttack.setVisibility(View.VISIBLE);
            holder.lutemonDefence.setVisibility(View.VISIBLE);
            holder.lutemonHealth.setVisibility(View.VISIBLE);
            holder.lutemonExp.setVisibility(View.VISIBLE);
        } else {
            holder.lutemonName.setVisibility(View.GONE);
            holder.lutemonAttack.setVisibility(View.GONE);
            holder.lutemonDefence.setVisibility(View.GONE);
            holder.lutemonHealth.setVisibility(View.GONE);
            holder.lutemonExp.setVisibility(View.GONE);
        }
        holder.lutemonName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getType() + ")");
        holder.lutemonAttack.setText("Hyökkäys: " + String.valueOf(lutemons.get(position).getAttack()));
        holder.lutemonDefence.setText("Puolustus: " + String.valueOf(lutemons.get(position).getDefence()));
        holder.lutemonHealth.setText("Elämä: " + String.valueOf(lutemons.get(position).getHealth()));
        holder.lutemonExp.setText("Kokemus: " + String.valueOf(lutemons.get(position).getExperience()));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
