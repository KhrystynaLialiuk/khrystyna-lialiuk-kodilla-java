package com.kodilla.rps;

import java.util.Random;

public class Computer {
    private int computerScore;

    Random randomChoice = new Random();

    public int makeChoice(){
        return (randomChoice.nextInt(3)+1);
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }
}
