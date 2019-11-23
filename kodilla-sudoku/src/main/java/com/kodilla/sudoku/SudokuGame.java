package com.kodilla.sudoku;

import java.util.Scanner;

class SudokuGame {
    private static String ERROR = "You might have made a mistype. Please consider all the rules of typing data.";
    private static String QUESTION_MESSAGE = "Please type \"C\" to continue and solve another sudoku " +
            "or any other key to exit the application.";
    private static String RANGE = "123456789";
    private SudokuBoard board = new SudokuBoard();
    private GameAnalyzer analyzer = new GameAnalyzer();
    private Scanner scan = new Scanner(System.in);

    boolean resolveSudoku() {
        System.out.println(board);
        setBoard();
        System.out.println(board);
        analyzer.analyzeSudoku(board);
        return askIfContinue();
    }

    private void setBoard() {
        boolean boardIsSet = false;
        while (!boardIsSet) {
            System.out.println("Enter message: ");
            String line = scan.next();
            if (line.toLowerCase().contains("sudoku")) {
                boardIsSet = true;
            } else {
                DtoUserMessage dtoUserMessage = analyzeLine(line);
                if (dtoUserMessage.isOfAppropriateFormat()) {
                    board.getSudokuRows().get(dtoUserMessage.getRow()).getSudokuElements().get(dtoUserMessage.getColumn())
                            .setValue(dtoUserMessage.getValue());
                    System.out.println(board);
                } else {
                    System.out.println(ERROR);
                }
            }
        }
    }

    private DtoUserMessage analyzeLine(String line) {
        try {
            String[] split = line.split(",");
            if ((split.length == 3) & (RANGE.contains(split[0])) & (RANGE.contains(split[1])) & (RANGE.contains(split[2]))) {
                return new DtoUserMessage(Integer.valueOf(split[0])-1,
                        Integer.valueOf(split[1])-1,
                        Integer.valueOf(split[2]), true);
            } else {
                return new DtoUserMessage(-1, -1, -1, false);
            }
        } catch (Exception e) {
            return new DtoUserMessage(-1, -1, -1, false);
        }
    }

    private boolean askIfContinue() {
        System.out.println(QUESTION_MESSAGE);
        String userMessage = scan.next();
        return !(userMessage.toLowerCase().contains("c"));
    }
}
