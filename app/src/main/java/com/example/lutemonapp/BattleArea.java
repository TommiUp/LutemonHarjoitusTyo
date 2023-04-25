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