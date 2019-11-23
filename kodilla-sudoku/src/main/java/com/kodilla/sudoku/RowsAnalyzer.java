package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.frequency;

public class RowsAnalyzer {
    private List<Integer> filledValues = new ArrayList<>();
    private boolean someElementFilled = false;

    public void analyze(SudokuBoard board) throws WrongGuessException {
        for (SudokuRow row : board.getSudokuRows()) {
            analyzeRow(row);
            filledValues.clear();
            someElementFilled = false;
        }
    }

    private void analyzeRow(SudokuRow row) throws WrongGuessException {
        collectFilledValues(row);
        checkForWrongGuessException(row);
        someElementFilled = deleteFilledValuesFromPossibleValues(row);
        if (!someElementFilled) {
            checkForUniquePossibleValues(row);
        }
        checkForDuplicatedFilledValues(row);
    }

    private void collectFilledValues(SudokuRow row) {
        for (SudokuElement element : row.getSudokuElements()) {
            if (element.getValue() > -1) {
                filledValues.add(element.getValue());
            }
        }
    }

    private boolean deleteFilledValuesFromPossibleValues(SudokuRow row) {
        boolean valueInserted = false;
        for (SudokuElement element : row.getSudokuElements()) {
            if (element.getValue() == -1) {
                List<Integer> toRemove = new ArrayList<>();
                for (int digit : element.getPossibleValues()) {
                    if (filledValues.contains(digit)) {
                        toRemove.add(digit);
                    }
                }
                for (int num : toRemove) {
                    if (element.getPossibleValues().size() > 1) {
                        element.getPossibleValues().remove(Integer.valueOf(num));
                    }
                }
                if (element.getPossibleValues().size() == 1) {
                    element.setValue(element.getPossibleValues().get(0));
                    filledValues.add(element.getPossibleValues().get(0));
                    valueInserted = true;
                }
            }
        }
        return valueInserted;
    }

    private void checkForWrongGuessException(SudokuRow row) throws WrongGuessException{
        for (SudokuElement element : row.getSudokuElements()) {
            if ((element.getValue() == -1) & (element.getPossibleValues().size() == 1) &
                    (filledValues.contains(element.getPossibleValues().get(0)))) {
                throw new WrongGuessException();
            }
        }
    }

    private void checkForUniquePossibleValues(SudokuRow row) {
        List<Integer> listOfPossibleValues = new ArrayList<>();
        for (SudokuElement element : row.getSudokuElements()) {
            if (element.getValue() == -1) {
                listOfPossibleValues.addAll(element.getPossibleValues());
            }
        }
        for (SudokuElement element : row.getSudokuElements()) {
            if (element.getValue() == -1) {
                for (int digit : element.getPossibleValues()) {
                    if (frequency(listOfPossibleValues, digit) == 1) {
                        element.setValue(digit);
                        filledValues.add(digit);
                    }
                }
            }
        }
    }

    private void checkForDuplicatedFilledValues(SudokuRow row) throws WrongGuessException {
        List<Integer> testingIfInsertionsCorrect = new ArrayList<>();
        for (SudokuElement element : row.getSudokuElements()) {
            testingIfInsertionsCorrect.add(element.getValue());
        }
        for (int num = 1; num <=9; num++) {
            if (frequency(testingIfInsertionsCorrect, num) > 1) {
                throw new WrongGuessException();
            }
        }
    }
}
