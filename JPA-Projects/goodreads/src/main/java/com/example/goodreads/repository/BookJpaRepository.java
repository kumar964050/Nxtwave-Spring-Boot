package com.example.goodreads.repository;
// 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
// 
import com.example.goodreads.model.Book;

@Service
public interface BookJpaRepository extends JpaRepository<Book, Integer> {
    //code here
 
}