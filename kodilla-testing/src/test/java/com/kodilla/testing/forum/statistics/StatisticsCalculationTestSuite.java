package com.kodilla.testing.forum.statistics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Random;

public class StatisticsCalculationTestSuite {
    @Test
    public void testCalculateAdvStatistics(){
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        StatisticsCalculation calculation = new StatisticsCalculation();

        ArrayList<String> list0 = new ArrayList<>();

        ArrayList<String> list100 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++){
            StringBuilder sb = new StringBuilder();
            for (int n = 0; n < random.nextInt(20) + 1; n++){
                sb.append("a");
            }
            list100.add(sb.toString());
        }

        when(statisticsMock.userNames()).thenReturn(list0, list100);
        when(statisticsMock.postsCount()).thenReturn(0,1000);
        when(statisticsMock.commentsCount()).thenReturn(0,500, 2000);

        //When first call of the method
        calculation.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, calculation.getAmountOfUsers());
        assertEquals(0, calculation.getAmountOfPosts());
        assertEquals(0, calculation.getAmountOfComments());
        assertEquals(0, calculation.getAmountOfPostsPerUser(), 0.01);
        assertEquals(0, calculation.getAmountOfCommentsPerUser(), 0.01);
        assertEquals(0, calculation.getAmountOfCommentsPerPost(), 0.01);

        //When second call of the method
        calculation.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, calculation.getAmountOfUsers());
        assertEquals(1000, calculation.getAmountOfPosts());
        assertEquals(500, calculation.getAmountOfComments());
        assertEquals(10, calculation.getAmountOfPostsPerUser(), 0.01);
        assertEquals(5, calculation.getAmountOfCommentsPerUser(), 0.01);
        assertEquals(0.5, calculation.getAmountOfCommentsPerPost(), 0.01);

        //When third call of the method
        calculation.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, calculation.getAmountOfUsers());
        assertEquals(1000, calculation.getAmountOfPosts());
        assertEquals(2000, calculation.getAmountOfComments());
        assertEquals(10, calculation.getAmountOfPostsPerUser(), 0.01);
        assertEquals(20, calculation.getAmountOfCommentsPerUser(), 0.01);
        assertEquals(2, calculation.getAmountOfCommentsPerPost(),0.01);
    }
}
