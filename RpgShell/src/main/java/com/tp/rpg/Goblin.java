package com.tp.rpg;

//goblins always attack?
public class Goblin extends NonPlayerCharacter {

    int health;
    String whichGob;
    public Goblin(String whichGoblin) {
        super(whichGoblin);
        health = 0;
        this.whichGob = whichGoblin;
    }

    @Override
    public void attack(Character defender) {
        if (whichGob.equals("attack1"))
            defender.takeDamage(1);
        else if (whichGob.equals("attack2"))
            defender.takeDamage(2);
        else if (whichGob.equals("attack3"))
            defender.takeDamage(3);
        else
            defender.takeDamage(4);
    }

    @Override
    public void takeDamage(int damage) {
        if (whichGob.equals("attack1"))
            health -= 4;
        else if (whichGob.equals("attack2"))
            health -= 3;
        else if (whichGob.equals("attack3"))
            health -= 2;
        else
            health -= 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) return false;
        else return true;
    }
    @Override
    public String getName() {
        return this.whichGob;
    }
}
