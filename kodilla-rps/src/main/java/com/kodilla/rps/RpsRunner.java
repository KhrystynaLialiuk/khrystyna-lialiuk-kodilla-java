package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        //rules description
        System.out.println("Welcome to RPS game!\n Please read rules of the game: \n" +
                "key 1 - choose ROCK\n" +
                "key 2 - choose PAPER\n" +
                "key 3 - choose SCISSORS\n" +
                "key x - exit the game\n" +
                "key n - start a new game\n");

        //running a game depending on player's decision
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;
        while (!(exitGame)){
            System.out.println("To start a new game please type n on the keyboard! To exit the game type x on the keyboard!");
            String messageFromPlayer = scanner.next();
            if (messageFromPlayer.contains("x")){
                System.out.println("Enter y (stands for YES) to exit:");
                String confirmation = scanner.next();
                if (confirmation.contains("y")){
                    exitGame = true;
                }
            } else if (messageFromPlayer.contains("n")){
                GameBodyRunner gameBodyRunner = new GameBodyRunner();
                gameBodyRunner.startGame();
            } else {
                System.out.println("You have pressed some other key. Please try again!");
            }
        }

        //message after decision to exit the game
        System.out.println("Thanks for playing!");
    }
}