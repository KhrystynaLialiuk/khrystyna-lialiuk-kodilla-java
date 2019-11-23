package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SudokuElement {
    private static int EMPTY = -1;
    private Integer value = EMPTY;
    private List<Integer> possibleValues = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    List<Integer> getPossibleValues() {
        return possibleValues;
    }
}
