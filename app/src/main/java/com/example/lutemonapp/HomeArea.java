package com.example.lutemonapp;
public class HomeArea extends LutemonStorage {

    private static HomeArea instance = null;

    public HomeArea() {
        super();
    }
    // Static method for returning the single instance of HomeArea, creating it if it does not exist
    public static HomeArea getInstance() {
        if (instance == null) {
            instance = new HomeArea();
        }
        return instance;
    }
}

