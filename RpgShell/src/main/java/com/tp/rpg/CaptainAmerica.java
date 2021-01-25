package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.armors.VibraniumShield;
import com.tp.rpg.weapons.CaptainStrength;
import com.tp.rpg.weapons.Weapon;

public class CaptainAmerica extends PlayerCharacter {
    private int health;
    VibraniumShield vShield;
    CaptainStrength cStrength;
    public CaptainAmerica() {
        super("captain america");
        this.health = 125;
        vShield = new VibraniumShield();
        cStrength = new CaptainStrength();
    }

    @Override
    public void attack(Character defender) {
        defender.takeDamage(cStrength.generateDamage());
    }

    @Override
    public void takeDamage(int damage) {
        health -= vShield.reduceDamage(damage);
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) return false;
        else return true;
    }

    @Override
    public String getName() {
        return "captain america";
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    @Override
    public Weapon getWeapon() {
        return cStrength;
    }

    @Override
    public Armor getArmor() {
        return vShield;
    }


}
