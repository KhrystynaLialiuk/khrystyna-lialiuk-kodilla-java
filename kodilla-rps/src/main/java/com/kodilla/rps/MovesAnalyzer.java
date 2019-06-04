package com.kodilla.rps;

public class MovesAnalyzer {
    public void analyzeChoices(Player player, int playerChoice, Computer computer, int computerChoice){
        if (playerChoice == computerChoice){
            System.out.println("  It is a draw!");
        } else if (playerChoice == 1) {
            if (computerChoice == 2){
                System.out.println("  Paper covers rock!");
                computer.setComputerScore(computer.getComputerScore()+1);
            } else if (computerChoice == 3){
                System.out.println("  Rock crushes scissors!");
                player.setPlayerScore(player.getPlayerScore() + 1);
            }
        } else if (playerChoice == 2) {
            if (computerChoice == 1) {
                System.out.println("  Paper covers rock!");
                player.setPlayerScore(player.getPlayerScore() + 1);
            } else if (computerChoice == 3){
                System.out.println("  Scissors cuts paper!");
                computer.setComputerScore(computer.getComputerScore() + 1);
            }
        } else if (playerChoice == 3){
            if (computerChoice == 1){
                System.out.println("  Rock crushes scissors!");
                computer.setComputerScore(computer.getComputerScore() + 1);
            } else if (computerChoice == 2){
                System.out.println("  Scissors cuts paper!");
                player.setPlayerScore(player.getPlayerScore() + 1);
            }
        }
    }
}
