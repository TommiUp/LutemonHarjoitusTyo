package com.example.lutemonapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
abstract class LutemonStorage implements Serializable {

    private static LutemonStorage instance = null;
    private ArrayList<Lutemon> lutemons;

    public LutemonStorage() {
        lutemons = new ArrayList<>();
        instance = this;
    }

    // Method for removing lutemons in an arraylist
    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    // Method for finding lutemons in an arraylist
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    // Method for adding lutemons to an arraylist
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    // Method for finding lutemons by their id
    public Lutemon getLutemonByIdWithoutRemove(int id) {
        return lutemons.get(id);
    }

    // Method for saving lutemons
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

    // Method for loading lutemons
    public void loadLutemons(Context context){
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
            System.out.println("Lutemonien lataaminen onnistui");
        } catch (FileNotFoundException e){
            System.out.println("Lutemonien lataaminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Lutemonien lataaminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Lutemonien lataaminen ei onnistunut");
            e.printStackTrace();
        }
    }
}
