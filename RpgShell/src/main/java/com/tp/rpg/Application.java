package com.tp.rpg;

public class Application {
    public static void main(String[] args) {

        System.out.println("Welcome to a quick game of Avengers! ");
        PlayerCharacter pc = setUpPlayer();

        System.out.println();
        while( pc.isAlive() ){
            NonPlayerCharacter enemy = setUpEnemy();

            battle( pc, enemy );


        }

        gameOverScreen();

    }

    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {
        System.out.println("Choose a player to play with: ");
        Character character = new Character();
        String currentCharacter = character.makeChoice();
        if (currentCharacter.equals("captain america")) return new CaptainAmerica();
        else if (currentCharacter.equals("iron man")) return new Ironman();
        else if (currentCharacter.equals("spider man")) return new Spiderman();
        else return new Thor();
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {
        Character character = new Character();
        String currentCharacter = character.makeChoiceNPC();
        Goblin gob = new Goblin(currentCharacter);
        if (currentCharacter.equals("attack1"))
            gob.setHealth(15);
        else if (currentCharacter.equals("attack2"))
            gob.setHealth(20);
        else if (currentCharacter.equals("attack3"))
            gob.setHealth(25);
        else
            gob.setHealth(30);
        return gob;
    }

    //a and b battle until one is dead
    private static void battle(Character a, Character b) {
        Character attacker = a;
        Character defender = b;
        while( a.isAlive() && b.isAlive() ){
            String aName = a.getName();
            String bName = b.getName();
            if( aName.equals("attack1") || aName.equals("attack2")
            || aName.equals("attack3") || aName.equals("attack4")) {
                attacker.attack(defender);
            } else {
                //TODO: consider other actions
                //

//                throw new UnsupportedOperationException();
            }

            Character temp = a;
            a = b;
            b = temp;

            //TODO: display HP status?

        }
    }

    //display some message
    private static void gameOverScreen() {

    }
}
