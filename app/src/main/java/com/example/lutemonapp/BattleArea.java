// Lutemon App, BattleArea
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Class for the lutemons that are stored in battle
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;
public class BattleArea extends LutemonStorage {

    private static BattleArea instance = null;

    public BattleArea() {
        super();
    }

    public static BattleArea getInstance() {
        if (instance == null) {
            instance = new BattleArea();
        }
        return instance;
    }
}