package com.mysoftltd.springStarter.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bookShops")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shop_id;
    private String shopName;
    private String location;
    @ManyToMany
    @JoinTable(
            name = "book_bookshop",
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "shop_id"))
//    private List<Book> books;
    private Set<Book> bookList = new HashSet<>();
    private String contact;
    private String email;
}
