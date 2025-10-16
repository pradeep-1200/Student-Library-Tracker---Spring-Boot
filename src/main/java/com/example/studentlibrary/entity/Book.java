package com.example.studentlibrary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String borrowedBy; // student name
    private String status; // Available / Borrowed

    // Constructors
    public Book() {}

    public Book(String title, String author, String borrowedBy, String status) {
        this.title = title;
        this.author = author;
        this.borrowedBy = borrowedBy;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getBorrowedBy() { return borrowedBy; }
    public void setBorrowedBy(String borrowedBy) { this.borrowedBy = borrowedBy; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
