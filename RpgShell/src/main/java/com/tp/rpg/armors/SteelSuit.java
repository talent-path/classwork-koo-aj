package com.tp.rpg.armors;

public class SteelSuit extends Armor  {
    public SteelSuit() {
        super("Steel Suit");
    }

    @Override
    public int reduceDamage(int startingDamage) {

        return startingDamage + 8;
    }
}
