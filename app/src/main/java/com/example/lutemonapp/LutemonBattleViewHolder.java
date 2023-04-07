package com.example.lutemonapp;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonBattleViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkboxBattle;

    public LutemonBattleViewHolder(@NonNull View itemView){
        super(itemView);
        checkboxBattle = itemView.findViewById(R.id.checkBattle);
    }
}

