package com.example.tutosSpringBoot.data.repositories;

import com.example.tutosSpringBoot.data.entities.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByEmail(String email);
}
