package com.example.lutemonapp;

import java.io.Serializable;
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
    private LutemonStorage storage;

    // Constructor for creating a Lutemon object with the given attributes
    public Lutemon(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = idCounter++;
        this.experience = 0;
        this.visibility = 0;
        storage = LutemonStorage.getInstance();
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
        visibility = 1;
    }

    public void makeInvisible() {
        visibility = 0;
    }

    public int getBattleStatus() {
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

    @Override
    public String toString() {
        return "Name: " + name + "\nColor: " + type + "\nAttack: " + attack + "\nDefense: " + defence + "\nExperience: " + experience + "\nHealth: " + health + "/" + maxHealth + "\n";
    }
}
