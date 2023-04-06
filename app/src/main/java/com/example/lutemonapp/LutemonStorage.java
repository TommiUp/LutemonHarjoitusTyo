package com.example.lutemonapp;

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
}
