package com.store.mysqlsampledatabase.repository;

import com.store.mysqlsampledatabase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static javax.swing.text.html.HTML.Tag.P;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT COUNT(p) FROM Product p" )
    Long countTotalProducts();
}
