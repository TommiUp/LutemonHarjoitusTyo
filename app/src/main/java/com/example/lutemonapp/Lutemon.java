package com.example.lutemonapp;

import java.io.Serializable;

public class Lutemon implements Serializable {
    private int img;
    private String name;
    private String type;
    private int attack;
    private int defence;
    private int experience;
    private int health;
    private int maxHealth;
    private int id;
    private int trainingDays;
    private int wins;
    private int lost;
    private boolean isChecked = false;

    private static int idCounter = 0;

    // Constructor for creating a Lutemon object with the given attributes
    public Lutemon(String name, String type) {
        this.name = name;
        this.type = type;
        this.id = idCounter++;
        this.experience = 0;
        this.trainingDays = 0;
        this.wins = 0;
        this.lost = 0;
        switch (type) {
            case "White":
                this.attack = 5;
                this.defence = 4;
                this.maxHealth = 20;
                this.img = R.drawable.img_white;
                break;
            case "Green":
                this.attack = 6;
                this.defence = 3;
                this.maxHealth = 19;
                this.img = R.drawable.img_green;
                break;
            case "Pink":
                this.attack = 7;
                this.defence = 2;
                this.maxHealth = 18;
                this.img = R.drawable.img_pink;
                break;
            case "Orange":
                this.attack = 8;
                this.defence = 1;
                this.maxHealth = 17;
                this.img = R.drawable.img_orange;
                break;
            case "Black":
                this.attack = 9;
                this.defence = 0;
                this.maxHealth = 16;
                this.img = R.drawable.img_black;
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
        attack += 1;
    }

    // Method for increasing training day stats
    public void increaseTrainingDays(){
        trainingDays++;
    }

    // Method for increasing victory stats
    public void increaseVictory(){
        wins++;
    }

    // Method for increasing defeat stats
    public void increaseDefeat(){
        lost++;
    }

    // Getters and setters for the attributes of the Lutemon object
    public void setName(String name) {
        this.name = name;
    }
    public int getWins(){
        return wins;
    }
    public int getLost(){
        return lost;
    }
    public int getTrainingDays(){
        return trainingDays;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public int getImg(){
        return img;
    }
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

    public void setMaxHealth() {
        health = maxHealth;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nColor: " + type + "\nAttack: " + attack + "\nDefense: " + defence + "\nExperience: " + experience + "\nHealth: " + health + "/" + maxHealth + "\n";
    }
}
