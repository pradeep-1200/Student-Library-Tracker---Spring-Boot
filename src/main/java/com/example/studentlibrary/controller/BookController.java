package com.example.studentlibrary.controller;

import com.example.studentlibrary.entity.Book;
import com.example.studentlibrary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", service.getAllBooks());
        return "books"; // books.html
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // add-book.html
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        book.setStatus("Available");
        service.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getBookById(id).orElseThrow());
        return "edit-book"; // edit-book.html
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        Book existing = service.getBookById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        service.saveBook(existing);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getBookById(id).orElseThrow());
        return "borrow-book"; // borrow-book.html
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Long id, @RequestParam String studentName) {
        service.borrowBook(id, studentName);
        return "redirect:/books";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        service.returnBook(id);
        return "redirect:/books";
    }
}
