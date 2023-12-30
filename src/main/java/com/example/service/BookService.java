package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Book;

public class BookService {
    private Map<String, Book> books = new HashMap<>();

    public List<Book> getBooks() {
        return new ArrayList<>(books.values());
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void updateBook(String id, Book book) {
        if (books.containsKey(id)) {
            books.put(id, book);
        }
    }

    public void deleteBook(String id) {
        books.remove(id);
    }
}
