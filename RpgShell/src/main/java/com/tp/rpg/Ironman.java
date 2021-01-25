package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.IronSuit;
import com.tp.rpg.weapons.LaserBeam;
import com.tp.rpg.weapons.Weapon;

public class Ironman extends PlayerCharacter {

    private int health;
    private IronSuit ironSuit;
    private LaserBeam laserBeam;
    public Ironman() {
        super("iron man");
        health = 120;
        ironSuit = new IronSuit();
        laserBeam = new LaserBeam();
    }

    @Override
    public void attack(Character defender) {
        defender.takeDamage(laserBeam.generateDamage());
    }

    @Override
    public void takeDamage(int damage) {
        health -= ironSuit.reduceDamage(damage);
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) return false;
        else return true;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    @Override
    public Armor getArmor() {
        return ironSuit;
    }
    @Override
    public Weapon getWeapon() {
        return laserBeam;
    }
    @Override
    public String getName() {
        return "iron man";
    }
}
