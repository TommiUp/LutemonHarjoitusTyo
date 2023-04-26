// Lutemon App, TrainingArea
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Class for the lutemons that are stored in training
// Android Studio
// Last Updated 26.4.2023

package com.example.lutemonapp;

public class TrainingArea extends LutemonStorage {
    private static TrainingArea instance = null;

    public TrainingArea() {
        super();
    }
    // Static method for returning the single instance of TrainingArea, creating it if it does not exist
    public static TrainingArea getInstance() {
        if (instance == null) {
            instance = new TrainingArea();
        }
        return instance;
    }
}
