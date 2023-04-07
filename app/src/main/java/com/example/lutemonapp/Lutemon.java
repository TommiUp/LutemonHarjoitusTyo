package com.example.lutemonapp;

import android.opengl.Visibility;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Lutemon implements Serializable {
    private String name;
    private String type;
    private int attack;
    private int defence;
    private int experience;
    private int health;
    private int maxHealth;
    private int id;

    private int visibility;

    private boolean isChecked = false;

    private static int idCounter = 0;

    // Constructor for creating a Lutemon object with the given attributes
    public Lutemon(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = idCounter++;
        this.experience = 0;
        this.visibility = 0;
        switch (type) {
            case "White":
                this.attack = 5;
                this.defence = 4;
                this.maxHealth = 20;
                break;
            case "Green":
                this.attack = 6;
                this.defence = 3;
                this.maxHealth = 19;
                break;
            case "Pink":
                this.attack = 7;
                this.defence = 2;
                this.maxHealth = 18;
                break;
            case "Orange":
                this.attack = 8;
                this.defence = 1;
                this.maxHealth = 17;
                break;
            case "Black":
                this.attack = 9;
                this.defence = 0;
                this.maxHealth = 16;
                break;
            default:
                System.out.println("Invalid color");
                break;
        }
        this.health = maxHealth;
    }

    // Method for attacking another Lutemon
    public int attack() {
        return attack;
    }

    // Method for defending against an attack
    public int defence() {
        return defence;
    }

    // Method for taking damage
    public void takeDamage(int damage) {
        health -= damage; // health = health - damage;
        if (health < 0) {
            health = 0;
        }
    }

    // Method for gaining experience points
    public void gainExperience() {
        System.out.println("Kokemusta annettiin");
        experience++;
        attack += experience;
    }

    public void makeVisible() {
        System.out.println("Lutemon tuli näkyväksi");
        visibility = 1;
    }

    public void makeInvisible() {
        System.out.println("Lutemon katosi");
        visibility = 0;
    }

    public int getVisibility() {
        return visibility;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    // Getters and setters for the attributes of the Lutemon object
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfCreatedLutemons() {
        return idCounter;
    }

    public void setMaxHealth() {
        health = maxHealth;
    }

    public void fight(Lutemon lutemon1, Lutemon lutemon2) {
        Random random = new Random(); // tällä saa math.random() eli lisäominaisuuus

        // Loop until one of the Lutemons has 0 or fewer health points
        while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {
            // Print the stats of the two Lutemons before each turn
            System.out.println(lutemon1.toString());
            System.out.println(lutemon2.toString());

            // Lutemon 1 attacks Lutemon 2
            int attack1 = lutemon1.attack();
            int defense2 = lutemon2.defence();
            int damage1 = attack1 - defense2;
            lutemon2.takeDamage(damage1);

            // Check if Lutemon 2 is still alive
            if (lutemon2.getHealth() > 0) {
                System.out.println(lutemon2.getName() + " managed to avoid death.");
                // Swap the positions of Lutemons 1 and 2
                Lutemon temp = lutemon1;
                lutemon1 = lutemon2;
                lutemon2 = temp;
            } else {
                System.out.println(lutemon2.getName() + " died.");
                // Add experience points to Lutemon 1, remove Lutemon 2 from the list of Lutemons on the Battlefield, and remove it from the Storage
                lutemon1.gainExperience();
                //lutemons.remove(lutemon2);
                //storage.removeLutemon(lutemon2.getId());
                break;
            }

            // Lutemon 2 attacks Lutemon 1
            int attack2 = lutemon2.attack();
            int defense1 = lutemon1.defence();
            int damage2 = attack2 - defense1;
            lutemon1.takeDamage(damage2);

            // Check if Lutemon 1 is still alive
            if (lutemon1.getHealth() <= 0) {
                System.out.println(lutemon1.getName() + " died.");
                // Add experience points to Lutemon 2, remove Lutemon 1 from the list of Lutemons on the Battlefield, and remove it from the Storage
                lutemon2.gainExperience();
                //lutemons.remove(lutemon1);
                //lutemons.removeLutemon(lutemon1.getId());
                break;
            }

        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nColor: " + type + "\nAttack: " + attack + "\nDefense: " + defence + "\nExperience: " + experience + "\nHealth: " + health + "/" + maxHealth + "\n";
    }
}
