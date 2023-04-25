package com.example.lutemonapp;
public class HomeArea extends LutemonStorage {

    private static HomeArea instance = null;

    public HomeArea() {
        super();
    }

    public static HomeArea getInstance() {
        if (instance == null) {
            instance = new HomeArea();
        }
        return instance;
    }
}

