package com.tp.rpg.armors;

public class VibraniumShield extends Armor {

    public VibraniumShield() {
        super("Vibranium Shield");
    }

    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage + 10;
    }
}
