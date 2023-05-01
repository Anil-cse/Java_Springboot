package com.global;

public class Game {
    private int gameId;
    private String gameName;
    private int noOfPlayer;


    public Game(int gameId, String gameName, int noOfPlayer) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.noOfPlayer = noOfPlayer;
    }

    public Game() {

    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNoOfPlayer() {
        return noOfPlayer;
    }

    public void setNoOfPlayer(int noOfPlayer) {
        this.noOfPlayer = noOfPlayer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", noOfPlayer=" + noOfPlayer +
                '}';
    }
}
