package com.example.lab7.dao;

import com.example.lab7.entity.Product;
import com.example.lab7.dto.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    //dùng @Query (Bài 1)
    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    //  dùng @Query (Bài 2)
    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    //  get inventory by category (Bài 3)
    @Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count " +
           " FROM Product o " +
           " GROUP BY o.category" +
           " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();

    //  DSL alternatives (Bài 4 & 5)
    // DSL: find by price between (Bài 4)
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // DSL: find all by name like with pageable (Bài 5)
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}
