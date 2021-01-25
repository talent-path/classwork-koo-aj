package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.SpiderSuit;
import com.tp.rpg.weapons.SpiderWeb;
import com.tp.rpg.weapons.Weapon;

public class Spiderman extends PlayerCharacter{

    private int health;
    SpiderSuit spiderSuit;
    SpiderWeb spiderWeb;
    public Spiderman() {
        super("spider man");
        health = 115;
        spiderSuit = new SpiderSuit();
        spiderWeb = new SpiderWeb();
    }

    @Override
    public void attack(Character defender) {
        defender.takeDamage(spiderWeb.generateDamage());
    }

    @Override
    public void takeDamage(int damage) {
        health -= spiderSuit.reduceDamage(damage);
    }

    @Override
    public String getName() {
        return "spider man";
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    @Override
    public Weapon getWeapon() {
        return spiderWeb;
    }

    @Override
    public Armor getArmor() {
        return spiderSuit;
    }

}
