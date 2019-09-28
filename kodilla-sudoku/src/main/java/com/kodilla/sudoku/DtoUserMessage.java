package com.kodilla.sudoku;

public class DtoUserMessage {
    private int column;
    private int row;
    private int value;
    private boolean appropriateFormat;

    public DtoUserMessage(int column, int row, int value, boolean appropriateFormat) {
        this.column = column;
        this.row = row;
        this.value = value;
        this.appropriateFormat = appropriateFormat;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAppropriateFormat() {
        return appropriateFormat;
    }

    public void setAppropriateFormat(boolean appropriateFormat) {
        this.appropriateFormat = appropriateFormat;
    }
}
