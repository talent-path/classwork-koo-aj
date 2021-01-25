package com.tp.rpg.weapons;


public abstract class Weapon {

    private String name;
    public Weapon(String str) {
        name = str;
    }
    public String getName() {
        return this.name;
    }
    //generate some amount of damage to be dealt
    public abstract int generateDamage();

}
