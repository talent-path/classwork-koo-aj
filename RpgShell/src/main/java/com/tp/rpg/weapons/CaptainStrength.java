package com.tp.rpg.weapons;

public class CaptainStrength extends Weapon {

    public CaptainStrength() {
        super("Captain Strength");
    }


    @Override
    public int generateDamage() {
        return 15;
    }
}
