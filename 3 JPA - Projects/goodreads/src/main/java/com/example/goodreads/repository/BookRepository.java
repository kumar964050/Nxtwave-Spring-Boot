package com.example.goodreads.repository;

import com.example.goodreads.model.Book;

import java.util.ArrayList;

public interface BookRepository {
    ArrayList<Book> getBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    void deleteBook(int id);
    Book updateBook(int id,Book book);

}