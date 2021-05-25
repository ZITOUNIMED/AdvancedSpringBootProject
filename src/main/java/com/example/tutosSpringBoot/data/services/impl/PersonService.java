package com.example.tutosSpringBoot.data.services.impl;

import java.util.List;
import java.util.Optional;

import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.repositories.PersonRepository;
import com.example.tutosSpringBoot.data.services.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements ICrudService<Person>{
    @Autowired
    private PersonRepository repository;

    @Override
    public Person save(Person entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public List<Person> findAll() {
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
}
