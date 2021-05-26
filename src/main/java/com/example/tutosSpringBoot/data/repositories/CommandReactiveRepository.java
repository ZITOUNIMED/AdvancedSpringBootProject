/*package com.example.tutosSpringBoot.data.repositories;

import com.example.tutosSpringBoot.data.entities.Command;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface CommandReactiveRepository extends ReactiveCrudRepository<Command, Long> {
    Flux<Command> findByPersonId(Long id);
    Flux<Command> findByProductId(long id);
}*/
