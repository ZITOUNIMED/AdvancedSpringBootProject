package com.example.tutosSpringBoot.data.repositories;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
    List<Product> findByPriceLessThan(float price);
    List<Product> findByPriceBetween(float price1, float price2);
    List<Product> findByPriceGreaterThan(float price);
    List<Product> findByCategoryName(String categoryName);
}
