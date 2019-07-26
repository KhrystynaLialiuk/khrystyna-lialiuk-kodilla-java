package com.kodilla.spring.portfolio;
;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().getTasks().add("Task 1");
        board.getInProgressList().getTasks().add("Task 2");
        board.getDoneList().getTasks().add("Task 3");
        //Then
        Assert.assertEquals("Task 1", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("Task 2", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("Task 3", board.getDoneList().getTasks().get(0));
    }
}
