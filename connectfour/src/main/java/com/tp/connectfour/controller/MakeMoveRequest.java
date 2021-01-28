package com.tp.connectfour.controller;

public class MakeMoveRequest {
    private Integer makeMove;
    private Integer gameId;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getMakeMove() {
        return makeMove;
    }

    public void getMakeMove(Integer makeMove) {
        this.makeMove = makeMove;
    }
}
