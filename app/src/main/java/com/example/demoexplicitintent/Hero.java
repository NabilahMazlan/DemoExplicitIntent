package com.example.demoexplicitintent;

import java.io.Serializable;

public class Hero implements Serializable {
    private String name;
    private int strength;
    private int teachnicalProwness;

    public Hero(String name, int strength, int teachnicalProwness) {
        this.name = name;
        this.strength = strength;
        this.teachnicalProwness = teachnicalProwness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getTeachnicalProwness() {
        return teachnicalProwness;
    }

    public void setTeachnicalProwness(int teachnicalProwness) {
        this.teachnicalProwness = teachnicalProwness;
    }
}
