package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.person.People;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import com.kodilla.stream.forumuser.*;

public class StreamMain {
    public static void main(String[] args) {
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
        System.out.println(poemBeautifier.beautify(myText, text -> "*" + text + "*"));
        System.out.println(poemBeautifier.beautify(myText, text -> text.replace('k', 'K')));
        System.out.println(poemBeautifier.beautify(myText, text -> "~" + text.replace('k', 'K') + "~"));

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        System.out.println("Using Stream to print a list of people:");
        People.getList().stream()
                .forEach(System.out::println);

        System.out.println(" ... by using method references:");
        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("... and lambda functions:");
        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        System.out.println("Printing lines longer then 11 characters");
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);


        System.out.println("Printing uppercase lines longer then 11 characters, where first letter of the name is M");
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);


        System.out.println("Printing books issued before 2005:");
        BookDirectory theBookDirectory1 = new BookDirectory();
        theBookDirectory1.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);


        System.out.println("The use of collectors.toList()...");
        BookDirectory theBookDirectory2 = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory2.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());
        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);


        System.out.println("The use of collectors.toMap()...");
        BookDirectory theBookDirectory3 = new BookDirectory();
        Map<String, Book> theResultMapOfBooks = theBookDirectory3.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));
        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        System.out.println("The use of collectors.joining...");
        BookDirectory theBookDirectory4 = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory4.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(theResultStringOfBooks);


        // Task "Stream of the ForumUser list"
        System.out.println("Executing task of making a stream of the ForumUser list");
        Forum forum = new Forum();
        int yearToday = 2019;
        int monthToday = 6;
        int dayToday = 1;
        Map<Integer, ForumUser> theResultMap = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .filter(forumUser -> (forumUser.getUserDateOfBirth().getYear() <= (yearToday - 20)))
                .filter(forumUser -> !((forumUser.getUserDateOfBirth().getYear() == (yearToday - 20)) &&
                        (forumUser.getUserDateOfBirth().getMonthValue() > monthToday)))
                .filter(forumUser -> !((forumUser.getUserDateOfBirth().getYear() == (yearToday - 20)) &&
                        (forumUser.getUserDateOfBirth().getMonthValue() == monthToday) &&
                        (forumUser.getUserDateOfBirth().getDayOfMonth() > dayToday)))
                .filter(forumUser -> forumUser.getAmountOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
        System.out.println("# elements: " + theResultMap.size());
        theResultMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
