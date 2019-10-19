package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Antoine de Saint-Exupery", "The Little Prince", 1943, "12345");
        Book book2 = new Book("Lewis Carroll", "Alice in Wonderland", 1865, "23456");
        Book book3 = new Book("Joanne Rowling", "Harry Potter and the Goblet of Fire", 2000, "34567");
        Book book4 = new Book("Dan Brown", "Inferno", 2013, "456789");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        assertEquals(2000, median);
    }
}
