package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        Book book1 = new Book("The Little Prince", "Antoine de Saint-Exupery", LocalDate.of(1943, 1, 1));
        Book book2 = new Book("Alice in Wonderland", "Lewis Carroll", LocalDate.of(1865, 1, 1));
        Book book3 = new Book("Harry Potter and the Goblet of Fire", "Joanne Rowling", LocalDate.of(2000, 1, 1));
        Book book4 = new Book("Harry Potter and the Deathly Hallows", "Joanne Rowling", LocalDate.of(2007, 1, 1));
        Book book5 = new Book("Inferno", "Dan Brown", LocalDate.of(2013, 1, 1));
        Book book6 = new Book("Harry Potter and the Cursed Child", "Joanne Rowling", LocalDate.of(2016, 1, 1));
        Book book7 = new Book("Origin", "Dan Brown", LocalDate.of(2017, 1, 1));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);
        library.getBooks().add(book6);
        library.getBooks().add(book7);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book7);

        //Then
        Assert.assertEquals(6, library.getBooks().size());
        Assert.assertEquals(6, clonedLibrary.getBooks().size());
        Assert.assertEquals(7, deepClonedLibrary.getBooks().size());
    }
}
