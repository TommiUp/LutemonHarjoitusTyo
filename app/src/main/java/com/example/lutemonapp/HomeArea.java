// Lutemon App, HomeArea
// Tommi Uponen, Elias Kukkonen, Elias Seppä
// Class for the lutemons that are stored in home
// Android Studio
// Last Updated 26.4.2023

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

