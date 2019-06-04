package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameBodyRunner {

    public void startGame() {

        //creating user's part
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name:");
        Player player = new Player(scan.nextLine());
        System.out.println("Hello, " + player.getPlayerName() + "! Please enter number of rounds:");
        int numberOfRounds = scan.nextInt();
        System.out.println(player.getPlayerName() + ", your game will have " + numberOfRounds + " rounds. So, let's start!");

        //creating a map (key, meaning)
        Map<Integer, String> choices = new HashMap<>();
        choices.put(1, "ROCK");
        choices.put(2, "PAPER");
        choices.put(3, "SCISSORS");

        //creating other objects necessary in game body
        Computer computer = new Computer();
        boolean endOfGame = false;
        int currentRound = 1;
        int playerChoice;
        int computerChoice;
        MovesAnalyzer movesAnalyzer = new MovesAnalyzer();

        //game body itself
        while (!endOfGame){
            System.out.println("Round # " + currentRound);
            playerChoice = player.makeChoice();
            computerChoice = computer.makeChoice();
            System.out.println("  Your choice: " + choices.get(playerChoice) + ", computer choice: " + choices.get(computerChoice));
            movesAnalyzer.analyzeChoices(player, playerChoice, computer, computerChoice);
            System.out.println("  Your score: " + player.getPlayerScore() + ", computer score: " + computer.getComputerScore() + "\n");
            if (currentRound == numberOfRounds){
                endOfGame = true;
                if (player.getPlayerScore() > computer.getComputerScore()){
                    System.out.println("Congratulations! You have won this game!\n");
                } else if (player.getPlayerScore() == computer.getComputerScore()){
                    System.out.println("It is a draw!\n");
                } else {
                    System.out.println("This time the computer has won the game. Let's try again\n");
                }
            }
            currentRound++;
        }
    }
}
