package com.example.lutemonapp;

import java.io.Serializable;

public class Lutemon implements Serializable{
    private String name;
    private String color;
    private int attack;
    private int defense;
    private int experience;
    private int health;
    private int maxHealth;
    private int id;
    private static int idCounter = 0;

    // Constructor for creating a Lutemon object with the given attributes
    public Lutemon(String name, String color) {
        this.name = name;
        this.color = color;
        this.id = idCounter++;
        this.experience = 0;
        switch (color) {
            case "White":
                this.attack = 5;
                this.defense = 4;
                this.maxHealth = 20;
                break;
            case "Green":
                this.attack = 6;
                this.defense = 3;
                this.maxHealth = 19;
                break;
            case "Pink":
                this.attack = 7;
                this.defense = 2;
                this.maxHealth = 18;
                break;
            case "Orange":
                this.attack = 8;
                this.defense = 1;
                this.maxHealth = 17;
                break;
            case "Black":
                this.attack = 9;
                this.defense = 0;
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
        return defense;
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
        experience++;
        attack += experience;
    }

    // Getters and setters for the attributes of the Lutemon object
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
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
        return "Name: " + name + "\nColor: " + color + "\nAttack: " + attack + "\nDefense: " + defense + "\nExperience: " + experience + "\nHealth: " + health + "/" + maxHealth + "\n";
    }
}
