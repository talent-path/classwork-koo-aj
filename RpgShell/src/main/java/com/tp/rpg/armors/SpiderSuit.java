package com.tp.rpg.armors;

public class SpiderSuit extends Armor {

    public SpiderSuit() {
        super("Spider Suit");
    }
    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage + 5;
    }
}
