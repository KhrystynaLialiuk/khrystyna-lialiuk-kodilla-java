package com.kodilla.sudoku;

public class SudokuRunner {
    private static String WELCOME_MESSAGE = "Welcome to Sudoku solver!";
    private static String RULES = "Please enter the data in the format \"1,2,3\" where 1 is a column number, " +
            "2 is a row number, 3 is a value of the cell.\nWhen finished entering data, type SUDOKU to start analyzing.";
    private static String ACKNOWLEDGEMENT = "Thanks for using the Sudoku solver!";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(RULES);

        boolean gameFinished = false;
        while(!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
        System.out.println(ACKNOWLEDGEMENT);
    }
}
