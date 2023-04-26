// Lutemon App, LutemonTrainingViewHolder
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// View holder for the recycler view in training activity
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonTrainingViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkboxTrain;
    TextView txtAttack, txtDefence, txtHealth, txtExp;

    public LutemonTrainingViewHolder(@NonNull View itemView){
        super(itemView);
        checkboxTrain = itemView.findViewById(R.id.checkTrain);
        txtAttack = itemView.findViewById(R.id.txtAttack);
        txtDefence = itemView.findViewById(R.id.txtDefence);
        txtHealth = itemView.findViewById(R.id.txtHealth);
        txtExp = itemView.findViewById(R.id.txtExp);
    }
}
