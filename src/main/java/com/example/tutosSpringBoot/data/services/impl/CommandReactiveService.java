/*package com.example.tutosSpringBoot.data.services.impl;

import com.example.tutosSpringBoot.data.entities.Command;
import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.entities.Product;
import com.example.tutosSpringBoot.data.repositories.CommandReactiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommandReactiveService{
    @Autowired
    private CommandReactiveRepository repository;

    public Flux<Command> findByPersonId(Long id){
        return repository.findByPersonId(id);
    }

    public Flux<Command> findByProductId(long id){
        return repository.findByProductId(id);
    }

    public Mono<Command> findById(long id){
        return repository.findById(id);
    }

    public Flux<Command> findAll(){
        return repository.findAll();
    }

    public Mono<Command> addCommand(Long personId, Long productId, int items){
        Person person = new Person();
        person.setId(personId);

        Product product = new Product();
        product.setId(productId);

        Command command = new Command();
        command.setPerson(person);
        command.setProduct(product);
        command.setItems(items);
        return repository.save(command);
    }
}
*/