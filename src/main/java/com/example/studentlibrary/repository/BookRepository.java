package com.example.studentlibrary.repository;

import com.example.studentlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom query if needed later
}
