package com.tp.hangman.services;

import com.tp.hangman.models.HangmanGame;
import com.tp.hangman.models.HangmanViewModel;
import com.tp.hangman.persistence.HangmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//handles the logic for the game
@Component
public class HangmanService {

    @Autowired
    HangmanDao dao;

    public HangmanViewModel getGameById(Integer gameId) {
        HangmanGame game = dao.getGameById( gameId );
        return convertModel( game );
    }

    private int counter = 0;

    public HangmanViewModel makeGuess(Integer gameId, String guess) throws NullGuessException, InvalidGuessException {
        if (guess == null) {
            throw new NullGuessException("Tried to make a guess on " + gameId + "with a null guess.");
        }

        if( guess.length() != 1){
            throw new InvalidGuessException("Tried to make a guess on " + gameId + ", but entered wrong length.");
        }

        if( gameId == null ){
            //TODO: make and throw a custom exception here
            return null;
        }

        HangmanGame game = dao.getGameById(gameId);

        //we'll assume here that the dao gives us back a null
        //if there's no matching game
        if( game == null) {
            return null;
        }
        if (counter == 5) {
            return null;
        }

        game.getGuessedLetters().add(guess.charAt(0));
        HangmanViewModel res = convertModel(game);
        if (res.getPartialWord().equals(res.getGuessedLetters()))
            return null;
        List<Character> list = game.getGuessedLetters();
        for (int i = 0; i < game.getHiddenWord().length(); i++) {
            for (char j : list) {
                if (j != game.getHiddenWord().charAt(i)) {
                    counter++;
                }
            }
        }
        if (counter == 5) return null;
        counter = 0;
        return res;

    }


    private HangmanViewModel convertModel(HangmanGame game) {
        //TODO: generate the string with all the letters hidden that have not been guessed
        //and build the view model object (using the setters)


        //  h e l l o
        //  "_e___"
        String partialWord = "";
        for(char letter : game.getHiddenWord().toCharArray()) {
            if (game.getGuessedLetters().contains(letter)) {
                partialWord += letter;
            } else {
                partialWord += '_';
            }
        }
        //... figure out the logic here
        HangmanViewModel toReturn = new HangmanViewModel();
        toReturn.setPartialWord( partialWord.toString() );
        toReturn.setGuessedLetters( game.getGuessedLetters() );

        return toReturn;
    }
}
