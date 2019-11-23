package com.kodilla.sudoku;

class DtoUserMessage {
    private int column;
    private int row;
    private int value;
    private boolean ofAppropriateFormat;

    DtoUserMessage(int column, int row, int value, boolean ofAppropriateFormat) {
        this.column = column;
        this.row = row;
        this.value = value;
        this.ofAppropriateFormat = ofAppropriateFormat;
    }

    int getColumn() {
        return column;
    }

    int getRow() {
        return row;
    }

    int getValue() {
        return value;
    }

    boolean isOfAppropriateFormat() {
        return ofAppropriateFormat;
    }
}
