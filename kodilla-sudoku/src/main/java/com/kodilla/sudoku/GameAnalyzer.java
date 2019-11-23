package com.kodilla.sudoku;

import java.util.ArrayList;

class GameAnalyzer {

    private static final String GUESS = "Nothing could be inserted, trying to guess.";
    private static final String CLONING_NOT_SUPPORTED = "Cloning is NOT supported!";
    private static final String WRONG_GUESS = "Wrong guess.";
    private static final String INPUT_ERROR = "Sudoku can't be solved. Probably the input is incorrect." +
            "(e.g. You have typed the save value in one row, one column or one block)";
    private static final String CONGRATULATION_MESSAGE = "Congratulations! Sudoku solved correctly!";
    private static final String REGRET_MESSAGE = "Something went wrong, board filled NOT correctly.";


    private RowsAnalyzer rowsAnalyzer = new RowsAnalyzer();
    private ColumnsAnalyzer columnsAnalyzer = new ColumnsAnalyzer();
    private BlockAnalyzer blockAnalyzer = new BlockAnalyzer();
    private BoardValidator boardValidator = new BoardValidator();
    private ArrayList<BacktrackObject> backtrack = new ArrayList<>();
    private boolean allFieldsFilled = false;

    void analyzeSudoku(SudokuBoard board) {
        boolean valueInserted;

        while (!allFieldsFilled) {
            try {
                int unfilledCellsBefore = countUnfilledCells(board);
                rowsAnalyzer.analyze(board);
                columnsAnalyzer.analyze(board);
                blockAnalyzer.analyze(board);
                int unfilledCellsAfter = countUnfilledCells(board);
                allFieldsFilled = unfilledCellsAfter == 0;
                valueInserted = unfilledCellsBefore > unfilledCellsAfter;
                if (!valueInserted) {
                    System.out.println(GUESS);
                    findFirstUnfilledElement:
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            if (board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() == -1) {
                                try {
                                    SudokuBoard clonedSudokuBoard = board.deepCopy();
                                    Coordinates coordinates = new Coordinates(i, j);
                                    int quessValue = board.getSudokuRows().get(j).getSudokuElements().get(i)
                                            .getPossibleValues().get(0);
                                    backtrack.add(new BacktrackObject(clonedSudokuBoard, coordinates, quessValue));
                                    board.getSudokuRows().get(j).getSudokuElements().get(i).setValue(quessValue);
                                } catch (CloneNotSupportedException e) {
                                    System.out.println(CLONING_NOT_SUPPORTED);
                                }
                                break findFirstUnfilledElement;
                            }
                        }
                    }
                }
            } catch (WrongGuessException e) {
                System.out.println(WRONG_GUESS);
                if (backtrack.size() >= 1) {
                    BacktrackObject lastBacktrackObject = backtrack.get(backtrack.size() - 1);
                    backtrack.remove(backtrack.size() - 1);
                    board = lastBacktrackObject.getBacktrackBoard();
                    board.getSudokuRows().get(lastBacktrackObject.getCoordinates().getRow())
                            .getSudokuElements().get(lastBacktrackObject.getCoordinates().getColumn())
                            .getPossibleValues().remove(Integer.valueOf(lastBacktrackObject.getGuessValue()));
                } else {
                    System.out.println(INPUT_ERROR);
                    break;
                }
            }
        }
        if (boardValidator.checkIfBoardFilledCorrectly(board)) {
            System.out.println(CONGRATULATION_MESSAGE);
            System.out.println(board);
        } else {
            System.out.println(REGRET_MESSAGE);
        }
    }

    private int countUnfilledCells(SudokuBoard board) {
        int unfilledElements = 0;
        for (SudokuRow row : board.getSudokuRows()) {
            for (SudokuElement element : row.getSudokuElements()) {
                if (element.getValue() == -1) {
                    unfilledElements++;
                }
            }
        }
       return unfilledElements;
    }
}
