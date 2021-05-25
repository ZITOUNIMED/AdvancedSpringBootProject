package com.example.tutosSpringBoot.data.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.tutosSpringBoot.data.entities.Category;
import com.example.tutosSpringBoot.data.repositories.CategoriesRepository;
import com.example.tutosSpringBoot.data.services.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService implements ICrudService<Category>{
    
    @Autowired
    private CategoriesRepository repository;

    @Override
    public Category save(Category entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Category> findAll() {
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

    public List<Category> findByName(String name) {
        return repository.findByName(name);
    }
}
