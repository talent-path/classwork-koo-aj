package com.tp.rpg.weapons;

public class SpiderWeb extends Weapon{

    private String name;
    public SpiderWeb() {
        super("hammer");
    }

    public String getName() {
        return name;
    }

    @Override
    public int generateDamage() {
        return 15;
    }
}
