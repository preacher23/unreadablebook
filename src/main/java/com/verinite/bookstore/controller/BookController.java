package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/getAllBooks")
    public List<Book> getBooks() {
        return bookService.getbooks();
    }

    @GetMapping("/viewBook/{book_id}")
    public Object getById(@PathVariable("book_id") int book_id) {
        return bookService.getById(book_id);
    }

    @PostMapping("/saveBooks")
    public Book createBook(@RequestBody Book books) {
        return bookService.createBook(books);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    public String deleteBookById(@PathVariable int bookId) {
        return bookService.deleteBookById(bookId);
    }

    @PutMapping("/updateBook/{book_id}")
    public Object updateBook(@PathVariable int book_id,@RequestBody Book books) {
        return bookService.updateBook(book_id,books);
    }


}
