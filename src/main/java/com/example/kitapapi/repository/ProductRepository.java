package com.example.kitapapi.repository;

import com.example.kitapapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStock(int stock);//stock değeri verdiğim değere eşit olan ürünleri bul

    List<Product> findByNameContainingIgnoreCase(String name);
}