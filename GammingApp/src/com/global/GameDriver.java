package com.global;

import java.util.Scanner;

public class GameDriver {
        public static void main(String[] args)  {
            Scanner sc=new Scanner(System.in);
            GameDao gameDao = new GameDaoImpl();
            while(true) {
                System.out.println("Enter input for required operation: ");
                System.out.println("1. add the GameData in game_Table ");
                System.out.println("2. Update the GameData in game_Table");
                System.out.println("3. Delete the GameData in game_Table");
                System.out.println("4. findById the GameData in game_Table");
                System.out.println("5. Get the GameData in game_Table");
                System.out.println("6. Exit");
                int input=sc.nextInt();
                if(input==6)
                    break;
                switch (input) {
                    case 1:{

                        Game game = new Game();
                        System.out.println("Enter your gameId : ");
                        Integer id = sc.nextInt();
                        System.out.println("Enter your gameName : ");
                        String name = sc.next();
                        System.out.println("Enter your noOfPlayers : ");
                        Integer no = sc.nextInt();
                        game.setGameId(id);
                        game.setGameName(name);
                        game.setNoOfPlayer(no);
                        gameDao.addGame(game);
                        break;
                    }
                    case 2: {
                        Game game = new Game();
                        System.out.println("Enter your gameId :");
                        Integer id = sc.nextInt();
                        System.out.println("Enter your gameName : ");
                        String name = sc.next();
                        System.out.println("Enter your noOfPlayers :");
                        Integer no = sc.nextInt();
                        game.setGameId(id);
                        game.setGameName(name);
                        game.setNoOfPlayer(no);
                        gameDao.updateGame(game);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter your gameId :");
                        Integer id = sc.nextInt();
                        gameDao.deleteGame(id);
                        break;
                    }
                    case 4: {
                        System.out.println("Enter your gameId :");
                        Integer id = sc.nextInt();
                        gameDao.findByGameId(id);
                        break;
                    }
                    case 5: {
                        gameDao.getAllGame();
                        break;
                    }
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }

    }


