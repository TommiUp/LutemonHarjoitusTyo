package com.example.lutemonapp;

public class TrainingArea extends LutemonStorage {
    private static TrainingArea instance = null;

    public TrainingArea() {
        super();
    }

    public static TrainingArea getInstance() {
        if (instance == null) {
            instance = new TrainingArea();
        }
        return instance;
    }
}
