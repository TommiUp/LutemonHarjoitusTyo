// Lutemon App, LutemonStatisticsViewHolder
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// View holder for the statistics recycler view
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonStatisticsViewHolder extends RecyclerView.ViewHolder {

    ImageView imgLutemon;
    TextView txtName, txtExp, txtWin, txtLost, txtDays;

    public LutemonStatisticsViewHolder(@NonNull View itemView){
        super(itemView);
        imgLutemon = itemView.findViewById(R.id.imgLutemon);
        txtName = itemView.findViewById(R.id.txtName);
        txtExp = itemView.findViewById(R.id.txtExp);
        txtWin = itemView.findViewById(R.id.txtWin);
        txtLost = itemView.findViewById(R.id.txtLost);
        txtDays = itemView.findViewById(R.id.txtDays);
    }
}
