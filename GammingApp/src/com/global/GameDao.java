package com.global;

import java.util.List;

public interface GameDao {
    Boolean addGame(Game game);
    public Game findByGameId(Integer gameId);
    List<Game> getAllGame();
    Boolean updateGame(Game game);
    Boolean deleteGame(Integer gameId);
}
