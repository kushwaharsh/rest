package com.example.service;

import com.example.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void testAddBookAndGetBook() {
        Book book = new Book("1", "Sample Book", "Sample Author", 2022);
        bookService.addBook(book);

        Book retrievedBook = bookService.getBook("1");
        assertNotNull(retrievedBook);
        assertEquals("1", retrievedBook.getId());
        assertEquals("Sample Book", retrievedBook.getTitle());
        assertEquals("Sample Author", retrievedBook.getAuthor());
        assertEquals(2022, retrievedBook.getPublicationYear());
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("2", "Old Title", "Old Author", 2010);
        bookService.addBook(book);

        Book updatedBook = new Book("2", "New Title", "New Author", 2021);
        bookService.updateBook("2", updatedBook);

        Book retrievedBook = bookService.getBook("2");
        assertNotNull(retrievedBook);
        assertEquals("2", retrievedBook.getId());
        assertEquals("New Title", retrievedBook.getTitle());
        assertEquals("New Author", retrievedBook.getAuthor());
        assertEquals(2021, retrievedBook.getPublicationYear());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("3", "Book to delete", "Delete Author", 2005);
        bookService.addBook(book);

        bookService.deleteBook("3");

        Book retrievedBook = bookService.getBook("3");
        assertNull(retrievedBook);
    }
    
    // Additional Test Methods Can Be Added Here
}
