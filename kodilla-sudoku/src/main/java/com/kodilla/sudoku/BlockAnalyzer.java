package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.frequency;

public class BlockAnalyzer {
    private List<Integer> filledValues = new ArrayList<>();
    private boolean someElementFilled = false;

    public void analyze(SudokuBoard board) throws WrongGuessException {
        for (int m = 0; m < 9; m+=3) {
            for (int n = 0; n < 9; n += 3) {
                analyzeBlock(m, n, board);
                filledValues.clear();
                someElementFilled = false;
            }
        }
    }

    private void analyzeBlock(int m, int n, SudokuBoard board) throws WrongGuessException {
        collectFilledValues(m, n, board);
        checkForWrongGuessException(m, n, board);
        someElementFilled = deleteFilledValuesFromPossibleValues(m, n, board);
        if (!someElementFilled) {
            checkForUniquePossibleValues(m, n, board);
        }
        checkForDuplicatedFilledValues(m, n, board);
    }

    private void collectFilledValues(int m, int n, SudokuBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue() > -1) {
                    filledValues.add(board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue());
                }
            }
        }
    }

    private boolean deleteFilledValuesFromPossibleValues(int m, int n, SudokuBoard board) {
        boolean valueInserted = false;
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue() == -1) {
                    List<Integer> toRemove = new ArrayList<>();
                    for (int digit : board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues()) {
                        if (filledValues.contains(digit)) {
                            toRemove.add(digit);
                        }
                    }
                    for (int num : toRemove) {
                        if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues().size() > 1) {
                            board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues()
                                    .remove(Integer.valueOf(num));
                        }
                    }
                    if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues().size() == 1) {
                        board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).setValue(board.getSudokuRows()
                                .get(j+n).getSudokuElements().get(i+m).getPossibleValues().get(0));
                        filledValues.add(board.getSudokuRows().get(j+n).getSudokuElements().get(i+m)
                                .getPossibleValues().get(0));
                        valueInserted = true;
                    }
                }
            }
        }
        return valueInserted;
    }

    private void checkForWrongGuessException(int m, int n, SudokuBoard board) throws WrongGuessException {
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue() == -1) &
                        (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues().size() == 1) &
                        (filledValues.contains(board.getSudokuRows().get(j+n).getSudokuElements().get(i+m)
                                .getPossibleValues().get(0)))) {
                    throw new WrongGuessException();
                }
            }
        }
    }

    private void checkForUniquePossibleValues(int m, int n, SudokuBoard board) {
        List<Integer> listOfPossibleValues = new ArrayList<>();
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue() == -1) {
                    listOfPossibleValues.addAll(board.getSudokuRows().get(j+n).getSudokuElements()
                            .get(i+m).getPossibleValues());
                }
            }
        }
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue() == -1) {
                    for (int digit : board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getPossibleValues()) {
                        if (frequency(listOfPossibleValues, digit) == 1) {
                            board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).setValue(digit);
                            filledValues.add(digit);
                        }
                    }
                }
            }
        }
    }

    private void checkForDuplicatedFilledValues(int m, int n, SudokuBoard board) throws WrongGuessException {
        List<Integer> testingIfInsertionsCorrect = new ArrayList<>();
        for (int i =0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testingIfInsertionsCorrect.add(board.getSudokuRows().get(j+n).getSudokuElements().get(i+m).getValue());
            }
        }
        for (int num = 1; num <=9; num++) {
            if (frequency(testingIfInsertionsCorrect, num) > 1) {
                throw new WrongGuessException();
            }
        }
    }
}
