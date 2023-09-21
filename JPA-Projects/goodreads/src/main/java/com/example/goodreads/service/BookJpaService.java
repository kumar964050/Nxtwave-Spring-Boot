
package com.example.goodreads.service;

// 
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.goodreads.repository.BookJpaRepository;
import com.example.goodreads.repository.BookRepository;
import com.example.goodreads.model.Book;

@Service
public class BookJpaService implements BookRepository {

  @Autowired
  private BookJpaRepository bookJpaRepository;

  // api 1
  @Override 
  public ArrayList<Book> getBooks(){
    List<Book> bookList = bookJpaRepository.findAll();
    ArrayList<Book> books = new ArrayList<>(bookList);
    return books;
  }

  // api 2
  @Override 
  public Book addBook(Book book){
    bookJpaRepository.save(book);
    return book;
  }

  // api 3
  @Override 
  public Book getBookById(int id){
    try{
      return bookJpaRepository.findById(id).get();
    }
    catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
  
  // api 4
  @Override 
  public Book updateBook(int id,Book book){
    Book findBook = getBookById(id);
    if(book.getName() != null) findBook.setName(book.getName());
    if(book.getImageUrl() != null) findBook.setImageUrl(book.getImageUrl());
    bookJpaRepository.save(findBook);
    return findBook;
  } 
  // api 5
  @Override 
  public void deleteBook(int id){
    try{
      bookJpaRepository.deleteById(id);
    }
    catch(Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }
   
}