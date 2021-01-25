package com.tp.rpg;

import com.tp.rpg.armors.Armor;
import com.tp.rpg.weapons.Weapon;

//TODO:
//      add a concept of hitpoints
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public class Character implements Chooser {


    public Character() {

    }
    //TODO: add fields for armor(s) and weapon(s)


    @Override
    public String makeChoice() {
        int choiceMade;
        while (true) {
            System.out.println("If you want to play as Captain America type 1. ");
            System.out.println("If you want to play as Iron Man type 2. ");
            System.out.println("If you want to play as Spider Man type 3. ");
            System.out.println("If you want to play as Thor type 4. ");
            choiceMade = Console.readInt("Choose from numbers 1-4 ", 1, 4);
            if (choiceMade != Integer.MIN_VALUE) break;
        }
        if (choiceMade == 1) return "captain america";
        else if (choiceMade == 2) return "iron man";
        else if (choiceMade == 3) return "spider man";
        else return "thor";
    }

    public String makeChoiceNPC() {
        int random = Rng.randInt(1, 4);

        if (random == 1) return "attack1";
        else if (random == 2) return "attack2";
        else if (random == 3) return "attack3";
        else return "attack4";
    }


    public String getName() {throw new UnsupportedOperationException();}

    public void attack( Character defender ){
        throw new UnsupportedOperationException();
    }

    public void takeDamage( int damage ){
        throw new UnsupportedOperationException();
    }

    public boolean isAlive(){
        throw new UnsupportedOperationException();
    }
    public Weapon getWeapon() {throw new UnsupportedOperationException();}
    public Armor getArmor() {throw new UnsupportedOperationException();}

}
