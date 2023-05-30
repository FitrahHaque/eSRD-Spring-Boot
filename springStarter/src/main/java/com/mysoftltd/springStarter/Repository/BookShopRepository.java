package com.mysoftltd.springStarter.Repository;

import com.mysoftltd.springStarter.model.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShopRepository extends JpaRepository<BookShop, Long> {
    BookShop findBookShopByShopNameIgnoreCase(String shop_name);
}
