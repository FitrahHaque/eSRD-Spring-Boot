package com.mysoftltd.springStarter.service;

import com.mysoftltd.springStarter.Repository.BookRepository;
import com.mysoftltd.springStarter.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> addNewBook(List<Book> new_book){
        return bookRepository.saveAll(new_book);
    }
    public List<Book> findBookByTitle(String title){
        return bookRepository.findByTitleContainsIgnoreCase(title);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    public Book updateBook(Long id, Book newBook) {
        bookRepository.updateBook(id, newBook.getTitle(), newBook.getPrice(), newBook.getYear(), newBook.getAuthor(),
                newBook.getGenre(), newBook.getPublisher(),newBook.getLanguage());
        return bookRepository.findById(id).orElse(null);
    }
}
