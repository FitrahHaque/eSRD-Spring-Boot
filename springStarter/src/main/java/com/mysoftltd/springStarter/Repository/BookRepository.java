package com.mysoftltd.springStarter.Repository;

import com.mysoftltd.springStarter.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByTitleContainsIgnoreCase(String title);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.title = ?2, b.price = ?3,  b.year = ?4, b.author = ?5, b.genre = ?6," +
            " b.publisher = ?7, b.language = ?8 WHERE b.id = ?1")
    int updateBook(Long id, String title, double price, int year, String author,
                   String genre, String publisher, String language);
}
