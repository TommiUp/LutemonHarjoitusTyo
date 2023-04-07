package com.example.lutemonapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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

    public void removeLutemon(int id) {
        lutemons.remove(id);
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
