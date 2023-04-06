package com.example.lutemonapp;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class LutemonStorage {

    private static LutemonStorage instance = null;
    private ArrayList<Lutemon> lutemons;

    private LutemonStorage() {
        lutemons = new ArrayList<>();
        instance = this;
    }

    public static LutemonStorage getInstance() {
        if (instance == null) {
            instance = new LutemonStorage();
        }
        return instance;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void saveLutemons(Context context){
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
            System.out.println("Lutemonien tallentaminen onnistui");
        } catch (IOException e){
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }
}
