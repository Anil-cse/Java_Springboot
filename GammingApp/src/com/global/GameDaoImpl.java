package com.global;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao{

    private Connection connection;
    public GameDaoImpl() {
        super();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Callable", "root", "Ag3484e@");
           // System.out.println("Mysql connection successful !");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Boolean addGame(Game game) {
        Boolean isRecordAdded = false;
        try {
            CallableStatement cs = this.connection.prepareCall("{call addGame(?,?,?)}");
            cs.setInt(1,game.getGameId());
            cs.setString(2,game.getGameName());
            cs.setInt(3,game.getNoOfPlayer());
            int count= cs.executeUpdate();
            if (count == 1)
                isRecordAdded = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRecordAdded;
    }

    @Override
    public Game findByGameId(Integer gameId) {
        Game foundGame = null;
        List<Game> games = new ArrayList<>();

        try {
            CallableStatement cs = this.connection.prepareCall("{call findGameById(?)}");
            cs.setInt(1,gameId);
            ResultSet result = cs.executeQuery();
            while (result.next()) {
                foundGame = new Game(result.getInt(1),result.getString(2),result.getInt(3));
                games.add(foundGame);
                System.out.println(foundGame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundGame;
    }

    @Override
    public List<Game> getAllGame() {
        Game game=null;
        List<Game> games = new ArrayList<>();
        try {
            CallableStatement cs = this.connection.prepareCall("{call getGames()}");
            ResultSet result = cs.executeQuery();
            while (result.next()) {
                 game =new Game(result.getInt("gameId"), result.getString("gameName"),  result.getInt("noOfPlayer")) ;
                 games.add(game);
               System.out.println(game);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    @Override
    public Boolean updateGame(Game game) {
        Boolean isRecodUpdated = false;
         try {
            CallableStatement cs = this.connection.prepareCall("{call updateGames (?,?,?)}");
            
            cs.setInt(1,game.getGameId());
            cs.setString(2,game.getGameName());
            cs.setInt(3,game.getNoOfPlayer());
           
            int count =  cs.executeUpdate();
            if (count==1)
                isRecodUpdated=true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return isRecodUpdated;
    }

    @Override
    public Boolean deleteGame(Integer gameId) {
        Boolean isRecodDeleted = false;

        try {
            CallableStatement cs = this.connection.prepareCall("{ call deleteGame(?)}");
            cs.setInt(1,gameId);
            int count = cs.executeUpdate();
            if (count == 1)
                isRecodDeleted = true;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return isRecodDeleted;
    }
}
