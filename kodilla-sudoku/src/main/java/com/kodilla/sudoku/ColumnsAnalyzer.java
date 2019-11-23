package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.frequency;

public class ColumnsAnalyzer {
    private List<Integer> filledValues = new ArrayList<>();
    private boolean someElementFilled = false;

    public void analyze(SudokuBoard board) throws WrongGuessException {
        for (int i = 0; i < 9; i++) {
            analyzeColumn(i, board);
            filledValues.clear();
            someElementFilled = false;
        }
    }

    private void analyzeColumn(int i, SudokuBoard board) throws WrongGuessException {
        collectFilledValues(i, board);
        checkForWrongGuessException(i, board);
        someElementFilled = deleteFilledValuesFromPossibleValues(i, board);
        if (!someElementFilled) {
            checkForUniquePossibleValues(i, board);
        }
        checkForDuplicatedFilledValues(i, board);
    }

    private void collectFilledValues(int i, SudokuBoard board) {
        for (int j = 0; j < 9; j++) {
            if (board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() > -1) {
                filledValues.add(board.getSudokuRows().get(j).getSudokuElements().get(i).getValue());
            }
        }
    }

    private boolean deleteFilledValuesFromPossibleValues(int i, SudokuBoard board) {
        boolean valueInserted = false;
        for (int j = 0; j < 9; j++) {
            if (board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() == -1) {
                List<Integer> toRemove = new ArrayList<>();
                for (int digit : board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues()) {
                    if (filledValues.contains(digit)) {
                        toRemove.add(digit);
                    }
                }
                for (int num : toRemove) {
                    if (board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues().size() > 1) {
                        board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues()
                                .remove(Integer.valueOf(num));
                    }
                }
                if (board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues().size() == 1) {
                    board.getSudokuRows().get(j).getSudokuElements().get(i).setValue(board.getSudokuRows().get(j)
                            .getSudokuElements().get(i).getPossibleValues().get(0));
                    filledValues.add(board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues().get(0));
                    valueInserted = true;
                }
            }
        }
        return valueInserted;
    }

    private void checkForWrongGuessException(int i, SudokuBoard board) throws WrongGuessException {
        for (int j = 0; j < 9; j++) {
            if ((board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() == -1) &
                    (board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues().size() == 1) &
                    (filledValues.contains(board.getSudokuRows().get(j).getSudokuElements().get(i)
                            .getPossibleValues().get(0)))) {
                throw new WrongGuessException();
            }
        }
    }

    private void checkForUniquePossibleValues(int i, SudokuBoard board) {
        List<Integer> listOfPossibleValues = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            if (board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() == -1) {
                listOfPossibleValues.addAll(board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues());
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board.getSudokuRows().get(j).getSudokuElements().get(i).getValue() == -1) {
                for (int digit : board.getSudokuRows().get(j).getSudokuElements().get(i).getPossibleValues()) {
                    if (frequency(listOfPossibleValues, digit) == 1) {
                        board.getSudokuRows().get(j).getSudokuElements().get(i).setValue(digit);
                        filledValues.add(digit);
                    }
                }
            }
        }
    }

    private void checkForDuplicatedFilledValues(int i, SudokuBoard board) throws WrongGuessException {
        List<Integer> testingIfInsertionsCorrect = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            testingIfInsertionsCorrect.add(board.getSudokuRows().get(j).getSudokuElements().get(i).getValue());
        }
        for (int num = 1; num <=9; num++) {
            if (frequency(testingIfInsertionsCorrect, num) > 1) {
                throw new WrongGuessException();
            }
        }
    }
}
