// Lutemon App, LutemonMoveViewHolder
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// View holder for the recycler view that contains lutemons that can be moved to different areas
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonMoveViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkboxName;

    public LutemonMoveViewHolder(@NonNull View itemView){
        super(itemView);
        checkboxName = itemView.findViewById(R.id.checkName);
    }
}
