package com.tp.connectfour.services;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.models.ConnectFourGame;
import com.tp.connectfour.models.ConnectFourViewModel;
import com.tp.connectfour.persistence.ConnectFourDao;
//import com.tp.connectfour.exceptions.InvalidGameIdException;
//import com.tp.connectfour.exceptions.InvalidGuessException;
import com.tp.connectfour.exceptions.NullGuessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConnectFourService {

    @Autowired
    ConnectFourDao dao;

    public ConnectFourViewModel startGame(){
        int randomPlayer = Rng.nextInt(1, 2);
        int startGame = (randomPlayer == 1) ? dao.startGame('X') : dao.startGame('O');
        return this.getGameById(startGame);
    }

    public List<ConnectFourViewModel> getAllGames() {
        List<ConnectFourGame> allGames = dao.getAllGames();
        List<ConnectFourViewModel> converted = new ArrayList<>();

        for( ConnectFourGame toConvert : allGames ){
            converted.add( convertModel(toConvert));
        }

        return converted;
    }

    public void deleteGame(Integer gameId) throws InvalidGameIdException {
        dao.deleteGame( gameId );
    }

    public ConnectFourViewModel getGameById(Integer gameId) {
        ConnectFourGame game = dao.getGameById(gameId);
        return convertModel(game);
    }

//    public ConnectFourViewModel makeMove(Integer gameId, String move) {
//        if( move == null )
//        {
//            throw new NullGuessException("Tried to make guess on game id " + gameId + " with a null guess.");
//        }
//
//        if( move.length() != 1){
//            throw new InvalidGuessException( "A guess of " + move + " is too long." );
//        }
//
//        if( gameId == null ){
//            throw new InvalidGameIdException( "Missing game id.");
//
//        }
//
//        ConnectFourGame game = dao.getGameById(gameId);
//
//        //we'll assume here that the dao gives us back a null
//        //if there's no matching game
//        if( game == null) {
//            throw new InvalidGameIdException( "Could not find game with id " + gameId );
//        }
//    }

    private ConnectFourViewModel convertModel(ConnectFourGame game) {
        ConnectFourViewModel toReturn = new ConnectFourViewModel();
        char[][] board = game.getGameBoard();

        toReturn.setCurrentPlayer(game.getCurrentPlayer());
        toReturn.setGameBoard( board );
        toReturn.setGameId(game.getGameId());

        return toReturn;
    }
}
