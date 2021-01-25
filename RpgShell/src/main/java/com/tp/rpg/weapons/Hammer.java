package com.tp.rpg.weapons;

public class Hammer extends Weapon {

    public Hammer() {
        super("Hammer");
    }

    @Override
    public int generateDamage() {
        return 20;
    }
}
