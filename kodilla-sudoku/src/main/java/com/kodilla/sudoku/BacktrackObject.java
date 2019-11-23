package com.kodilla.sudoku;

public class BacktrackObject {
    private SudokuBoard backtrackBoard;
    private Coordinates coordinates;
    private int guessValue;

    public BacktrackObject(SudokuBoard backtrackBoard, Coordinates coordinates, int guessValue) {
        this.backtrackBoard = backtrackBoard;
        this.coordinates = coordinates;
        this.guessValue = guessValue;
    }

    public SudokuBoard getBacktrackBoard() {
        return backtrackBoard;
    }

    public void setBacktrackBoard(SudokuBoard backtrackBoard) {
        this.backtrackBoard = backtrackBoard;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getGuessValue() {
        return guessValue;
    }

    public void setGuessValue(int guessValue) {
        this.guessValue = guessValue;
    }
}
