package com.tp.connectfour.models;

import java.util.ArrayList;
import java.util.List;

public class ConnectFourGame {

    private Integer gameId;
    private Integer chosenCol;
    private List<Integer> guessedCol;
    private Character currentPlayer;
    private char[][] gameBoard;

    public Integer getGameId() { return gameId; }
    public char[][] getGameBoard() {
        return gameBoard;
    }
    public Character getCurrentPlayer() {
        return currentPlayer;
    }
    public Integer getChosenCol() {
        return chosenCol;
    }

    public List<Integer> getGuessedCol() {
        return guessedCol;
    }



    /**
     * Main Constructor
     * @param gameId
     * @param currentPlayer
     */
    public ConnectFourGame(Integer gameId, Character currentPlayer){
        this.gameId = gameId;
        this.currentPlayer = currentPlayer;
        guessedCol = new ArrayList<>();
        gameBoard = new char[6][7];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                gameBoard[i][j] = '_';
            }
        }
    }

    //copy constructor
    public ConnectFourGame( ConnectFourGame that ){
        this.gameId = that.gameId;
        this.currentPlayer = that.currentPlayer;
        guessedCol = new ArrayList<>();
        gameBoard = new char[6][7];

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                gameBoard[i][j] = '_';
            }
        }
    }


}
