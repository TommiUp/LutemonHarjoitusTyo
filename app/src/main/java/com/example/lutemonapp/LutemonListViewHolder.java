// Lutemon App, LutemonListViewHolder
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Holder for the home screen recycler view
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListViewHolder extends RecyclerView.ViewHolder {


    ImageView imgLutemon, imgDelete, imgEdit;

    TextView lutemonName, lutemonAttack, lutemonDefence, lutemonHealth, lutemonExp;

    EditText editName;



    public LutemonListViewHolder(@NonNull View itemView){
        super(itemView);
        imgLutemon=itemView.findViewById(R.id.imgLutemon);
        lutemonName = itemView.findViewById(R.id.txtName);
        lutemonAttack= itemView.findViewById(R.id.txtAttack);
        lutemonDefence= itemView.findViewById(R.id.txtDefence);
        lutemonHealth = itemView.findViewById(R.id.txtHealth);
        lutemonExp = itemView.findViewById(R.id.txtExp);
        imgDelete = itemView.findViewById(R.id.imageDelete);
        imgEdit = itemView.findViewById(R.id.imageEdit);
        editName = itemView.findViewById(R.id.editNameText);
    }
}

