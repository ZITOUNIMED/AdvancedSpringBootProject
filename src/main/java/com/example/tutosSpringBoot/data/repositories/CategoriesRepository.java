package com.example.tutosSpringBoot.data.repositories;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
}
