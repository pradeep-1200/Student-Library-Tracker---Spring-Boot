package com.example.studentlibrary.service;

import com.example.studentlibrary.entity.Book;
import com.example.studentlibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public Book borrowBook(Long id, String studentName) {
        Book book = repository.findById(id).orElseThrow();
        book.setBorrowedBy(studentName);
        book.setStatus("Borrowed");
        return repository.save(book);
    }

    public Book returnBook(Long id) {
        Book book = repository.findById(id).orElseThrow();
        book.setBorrowedBy(null);
        book.setStatus("Available");
        return repository.save(book);
    }
}
