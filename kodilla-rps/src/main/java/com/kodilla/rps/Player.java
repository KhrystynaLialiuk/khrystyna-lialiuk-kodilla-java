package com.kodilla.rps;

import java.util.Scanner;

public class Player {
    private String playerName;
    private int playerScore;
    Scanner playerScanner = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int makeChoice(){
        System.out.println("Make your choice: ");
        int choice = 0;
        boolean choiceMade = false;
        while (!choiceMade){
            choice = playerScanner.nextInt();
            if ((choice == 1) || (choice == 2) || (choice == 3)){
                choiceMade = true;
            } else {
                System.out.println("Probably you typed some other number. " +
                        "You can choose only between 1, 2 and 3. Please try again!");
            }
        }
        return choice;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
