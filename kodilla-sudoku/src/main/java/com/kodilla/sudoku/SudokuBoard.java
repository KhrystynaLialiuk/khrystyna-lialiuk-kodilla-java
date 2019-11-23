package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    @Override
    public String toString() {
        String pipe = " | ";
        String dashes = " ----------------------------";
        String newLine = "\n";
        int counterRow = 0;
        int counterColumn = 0;

        StringBuilder s = new StringBuilder();
        s.append(dashes).append(newLine);

        for (SudokuRow row : sudokuRows){
            counterRow++;
            s.append(pipe);
            for (SudokuElement element : row.getSudokuElements()){
                counterColumn++;
                if (element.getValue() == -1) {
                    s.append(element.getValue());
                } else {
                    s.append(" ").append(element.getValue());
                }
                if (counterColumn%3 == 0){
                    s.append(pipe);
                }
            }
            s.append(newLine);
            if (counterRow%3 == 0){
                s.append(dashes).append(newLine);
            }
        }
        return s.toString();
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard)super.clone();
        clonedBoard.sudokuRows = new ArrayList<>();
        for (SudokuRow row : sudokuRows) {
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.getSudokuElements().clear();
            for (SudokuElement element : row.getSudokuElements()) {
                SudokuElement clonedElement = new SudokuElement();
                clonedElement.setValue(element.getValue());
                clonedElement.getPossibleValues().clear();
                for (Integer possibleValue : element.getPossibleValues()) {
                    clonedElement.getPossibleValues().add(possibleValue);
                }
                clonedRow.getSudokuElements().add(clonedElement);
            }
            clonedBoard.getSudokuRows().add(clonedRow);
        }
        return clonedBoard;
    }
}
