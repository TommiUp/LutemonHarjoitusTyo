package com.example.lutemonapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {


    ImageView imgLutemonKuva;

    TextView LutemonNimi, LutemonHyokkays, elama, kokemus;



    public LutemonViewHolder(@NonNull View itemView){
        super(itemView);
        imgLutemonKuva=itemView.findViewById(R.id.);
        LutemonNimi=itemView.findViewById(R.id.);
        LutemonHyokkays=itemView.findViewById(R.id.);
        elama=itemView.findViewById(R.id.);
        kokemus=itemView.findViewById(R.id.);

    }

}

