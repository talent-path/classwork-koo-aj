package com.tp.rpg.armors;

import com.tp.rpg.Ironman;

public class IronSuit extends Armor {
    public IronSuit() {
        super("Iron Suit");
    }
    @Override
    public int reduceDamage(int startingDamage) {
        return startingDamage + 5;
    }
}
