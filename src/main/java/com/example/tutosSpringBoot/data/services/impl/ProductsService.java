package com.example.tutosSpringBoot.data.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.tutosSpringBoot.data.entities.Product;
import com.example.tutosSpringBoot.data.repositories.ProductsRepository;
import com.example.tutosSpringBoot.data.services.ICrudService;
import com.example.tutosSpringBoot.utils.CategoriesEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements ICrudService<Product>{
    @Autowired
    private ProductsRepository repository;

    @Override
    public Product save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Product> findAll() {
        return Streamable.of(repository.findAll()).toList();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Product> findByPriceLessThan(float price){
        return repository.findByPriceLessThan(price);
    }

    public List<Product> findByPriceBetween(float price1, float price2){
        return repository.findByPriceBetween(price1, price2);
    }

    public List<Product> findByPriceGreaterThan(float price){
        return repository.findByPriceGreaterThan(price);
    }

    public List<Product> findCheapProducts(){
        return repository.findByCategoryName(CategoriesEnum.CHEAP_PRODUCTS.getRef());
    }

    public List<Product> findExpensiveProducts(){
        return repository.findByCategoryName(CategoriesEnum.EXPENSIVEE_PRODUCTS.getRef());
    }

    public List<Product> findTooExpensiveProducts(){
        return repository.findByCategoryName(CategoriesEnum.TOO_EXPENSIVE_PRODUCTS.getRef());
    }
}
