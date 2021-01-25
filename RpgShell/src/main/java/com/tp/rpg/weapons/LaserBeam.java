package com.tp.rpg.weapons;

public class LaserBeam extends Weapon {

    public LaserBeam() {
        super("Laser Beam");
    }


    @Override
    public int generateDamage() {
        return 20;
    }
}
