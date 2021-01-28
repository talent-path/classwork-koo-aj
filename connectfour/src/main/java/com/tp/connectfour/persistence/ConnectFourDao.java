package com.tp.connectfour.persistence;

import com.tp.connectfour.exceptions.InvalidGameIdException;
import com.tp.connectfour.models.ConnectFourGame;

import java.util.List;

public interface ConnectFourDao {

    int startGame(Character player);

    ConnectFourGame getGameById(Integer gameId);

    List<ConnectFourGame> getAllGames();

    void deleteGame(Integer gameId) throws InvalidGameIdException;
}
