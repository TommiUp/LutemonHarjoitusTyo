package com.example.lutemonapp;
public class BattleArea extends LutemonStorage {

    private static BattleArea instance = null;

    public BattleArea() {
        super();
    }
    
    //Static method for returning the single instance of BattleArea, creating it if it does not exist
    public static BattleArea getInstance() {
        if (instance == null) {
            instance = new BattleArea();
        }
        return instance;
    }
}
