package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class NewExceptionModuleRunner {
    public static void main(String[] args){
        FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
