package com.tp.hangman.models;

import java.util.List;

public class HangmanViewModel {
    String partialWord;
    List<Character> guessedLetters;

    // TODO: Do we need a constructor here?
    public String getPartialWord() {
        return partialWord;
    }

    public void setPartialWord(String partialWord) {
        this.partialWord = partialWord;
    }

    public List<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(List<Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }
}
