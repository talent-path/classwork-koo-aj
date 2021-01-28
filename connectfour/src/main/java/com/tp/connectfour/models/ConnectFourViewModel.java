package com.tp.connectfour.models;

import java.util.HashMap;
import java.util.List;

public class ConnectFourViewModel {

    private Integer gameId;
    private Character currentPlayer;
    char[][] gameBoard;
    HashMap<Integer, Integer> column;

    public Integer getGameId(){
        return gameId;
    }

    public void setGameId(Integer gameId){
        this.gameId = gameId;
    }

    public char[][] getGameBoard(){
        return gameBoard;
    }

    public void setCurrentPlayer(Character currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public Character getCurrentPlayer() {
        return this.currentPlayer;
    }
    public HashMap<Integer, Integer> getColumn(){
        return column;
    }

    public void setColumn(HashMap<Integer, Integer> column) {
        this.column = column;
    }

    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
