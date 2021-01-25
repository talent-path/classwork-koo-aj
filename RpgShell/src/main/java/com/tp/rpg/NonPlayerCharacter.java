package com.tp.rpg;

public class NonPlayerCharacter extends Character {

    String characterName;
    public NonPlayerCharacter(String characterName) {
        this.characterName = characterName;
    }
//
//    @Override
//    public String makeChoice() {
//        int random = Rng.randInt(1, 4);
//
//        if (random == 1) return "attack1";
//        else if (random == 2) return "attack2";
//        else if (random == 3) return "attack3";
//        else return "attack4";
//    }
    public String getCharacterName() {
        return this.characterName;
    }
}
