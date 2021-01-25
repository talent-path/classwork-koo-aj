package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.SteelSuit;
import com.tp.rpg.weapons.Hammer;
import com.tp.rpg.weapons.Weapon;

public class Thor extends PlayerCharacter{
    private int health;
    private SteelSuit steelSuit;
    private Hammer hammer;
    public Thor() {
        super("thor");
        health = 125;
        steelSuit = new SteelSuit();
        hammer = new Hammer();
    }

    @Override
    public void attack(Character defender) {
        defender.takeDamage(hammer.generateDamage());
    }

    @Override
    public void takeDamage(int damage) {
        health -= steelSuit.reduceDamage(damage);
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) return false;
        else return true;
    }

    @Override
    public String getName() {
        return "thor";
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    @Override
    public Weapon getWeapon() {
        return hammer;
    }

    @Override
    public Armor getArmor() {
        return steelSuit;
    }

}
