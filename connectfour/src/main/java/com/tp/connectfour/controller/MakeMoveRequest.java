package com.tp.connectfour.controller;

public class MakeMoveRequest {
    private String makeMove;
    private Integer gameId;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getMakeMove() {
        return makeMove;
    }

    public void getMakeMove(String makeMove) {
        this.makeMove = makeMove;
    }
}
