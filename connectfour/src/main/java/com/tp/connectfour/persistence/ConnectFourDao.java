package com.tp.connectfour.persistence;

import com.tp.connectfour.models.ConnectFourGame;

public interface ConnectFourDao {

    int startGame(Character player);

    ConnectFourGame getGameById(Integer gameId);

}
