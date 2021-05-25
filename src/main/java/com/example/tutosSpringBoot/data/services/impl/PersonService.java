package com.example.tutosSpringBoot.data.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.repositories.PersonRepository;
import com.example.tutosSpringBoot.data.services.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements ICrudService<Person>{
    @Autowired
    private PersonRepository repository;

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public Person save(Person entity) {
        return repository.save(entity);
    }

    @Override
    //@PostAuthorize("hasRole('ROLE_ADMIN'")
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostFilter("filterObject.email != authentication.principal.username")
    public List<Person> findAll() {
        return Streamable.of(repository.findAll())
        .stream()
        .peek(person -> {person.setPassword("");})
        .collect(Collectors.toList());
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

    public Person findByEmail(String email){
        return repository.findByEmail(email);
    }
}
