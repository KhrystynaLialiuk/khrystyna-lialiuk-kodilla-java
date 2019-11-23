package com.kodilla.sudoku;

import java.util.HashSet;

public class BoardValidator {
    public boolean checkIfBoardFilledCorrectly(SudokuBoard board) {
        return checkIfRowFilledCorrectly(board) & checkIfColumnFilledCorrectly(board) &
                checkIfBlockFilledCorrectly(board);
    }

    private boolean checkIfRowFilledCorrectly(SudokuBoard board) {
        boolean rowFilledCorrectly = true;
        for (SudokuRow row : board.getSudokuRows()) {
            HashSet<Integer> testingSet = new HashSet<>();
            for (SudokuElement element : row.getSudokuElements()) {
                testingSet.add(element.getValue());
            }
            rowFilledCorrectly = testingSet.size() == 9;
            if (!rowFilledCorrectly) {
                break;
            }
        }
        return rowFilledCorrectly;
    }

    private boolean checkIfColumnFilledCorrectly(SudokuBoard board) {
        boolean columnFilledCorrectly = true;
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> testingSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                testingSet.add(board.getSudokuRows().get(j).getSudokuElements().get(i).getValue());
            }
            columnFilledCorrectly = testingSet.size() == 9;
            if (!columnFilledCorrectly) {
                break;
            }
        }
        return columnFilledCorrectly;
    }

    private boolean checkIfBlockFilledCorrectly(SudokuBoard board) {
        boolean blockFilledCorrectly = true;
        for (int m = 0; m < 9; m += 3) {
            for (int n = 0; n < 9; n += 3) {
                HashSet<Integer> testingSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        testingSet.add(board.getSudokuRows().get(j + n).getSudokuElements().get(i + m).getValue());
                    }
                }
                blockFilledCorrectly = testingSet.size() == 9;
                if (!blockFilledCorrectly) {
                    break;
                }
            }
        }
        return blockFilledCorrectly;
    }
}
