package com.tp.rpg.armors;

public abstract class Armor {

    private String name;
    public Armor(String str) {
        this.name = str;
    }
    public String getName() {
        return name;
    }
    //takes in an amount of damage dealt
    //outputs the amount of damage to actually take
    public abstract int reduceDamage( int startingDamage );

}
