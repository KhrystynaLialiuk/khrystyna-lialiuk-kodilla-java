package com.kodilla.patterns2.observer.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MentorTestSuite {
    @Test
    public void testUpdate() {
        //Given
        Mentor benKowalski = new Mentor("Ben Kowalski");
        Mentor johnWind = new Mentor("John Wind");
        TaskQueue khrystynaLialiuk = new TaskQueue("Khrystyna Lialiuk");
        khrystynaLialiuk.registerObserver(benKowalski);
        TaskQueue leoJackson = new TaskQueue("Leo Jackson");
        leoJackson.registerObserver(benKowalski);
        TaskQueue kimManore = new TaskQueue("Kim Manore");
        kimManore.registerObserver(johnWind);
        //When
        khrystynaLialiuk.addTask("Observer pattern");
        leoJackson.addTask("Facade pattern");
        kimManore.addTask("Decorator pattern");
        //Then
        assertEquals(2, benKowalski.getUpdateCount());
        assertEquals(1, johnWind.getUpdateCount());
    }
}
