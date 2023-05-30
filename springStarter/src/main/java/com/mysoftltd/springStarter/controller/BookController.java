package com.mysoftltd.springStarter.controller;

import com.mysoftltd.springStarter.model.Book;
import com.mysoftltd.springStarter.model.BookShop;
import com.mysoftltd.springStarter.service.BookService;
import com.mysoftltd.springStarter.service.BookShopService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookShopService bookShopService;
    @GetMapping("")
    public List<Book> getAllBooks(){
        System.out.println("Get All Books");
        return bookService.getAllBooks();
    }
    @PostMapping("")
    public List<Book> addNewBook(@RequestBody List<Book> newBook){
        System.out.println("Add a new Book: " + newBook);
        return bookService.addNewBook(newBook);
    }
    @PostMapping("/title/{title}")
    public List<Book> findBookByTitle(@PathVariable String title){
        System.out.println("Find Book By Title: " + title);
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        System.out.println("Find id: " + id);
        Book book = bookService.findBookById(id);
        if(book == null){
            return null;
        }
        return book;
    }
    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable Long id, HttpServletResponse response) throws IOException {
        System.out.println("Delete id: " + id);
        Book book = bookService.findBookById(id);
        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book with id " + id + " not found.");
            return;
        }
        bookShopService.deleteBookByID(id);
        bookService.deleteBookById(id);
    }
    @DeleteMapping("")
    public void deleteAllBooks() {
        System.out.println("Delete all books");
        bookService.deleteAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook, HttpServletResponse response) throws IOException {
        System.out.println("Update book: " + newBook);
        Book book = bookService.findBookById(id);
        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Book with id " + id + " not found.");
            return null;
        }
        return bookService.updateBook(id, newBook);
    }
}
