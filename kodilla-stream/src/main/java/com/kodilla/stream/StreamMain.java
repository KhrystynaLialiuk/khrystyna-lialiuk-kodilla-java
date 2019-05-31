package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){
        System.out.println("Welcome to module 7 - Stream");

        // learning lambda
        SaySomething saySomething = new SaySomething();
        saySomething.say();
        // ->
        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);
        // ->
        Processor processor1 = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor1.execute(codeToExecute);
        // ->
        Processor processor2 = new Processor();
        processor2.execute(() -> System.out.println("This is an example text."));

        // practicing lambda and method references
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        // executing task: beautifying text
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String myText = "kodilla";
        System.out.println(poemBeautifier.beautify(myText, text -> "ABC " + text + " ABC"));
        System.out.println(poemBeautifier.beautify(myText, text -> text.toUpperCase()));
        System.out.println(poemBeautifier.beautify(myText, text -> "*"+text+"*"));
        System.out.println(poemBeautifier.beautify(myText, text -> text.replace('k', 'K')));
        System.out.println(poemBeautifier.beautify(myText, text -> "~" + text.replace('k', 'K') + "~"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
