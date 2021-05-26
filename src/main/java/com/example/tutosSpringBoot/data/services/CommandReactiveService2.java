package com.example.tutosSpringBoot.data.services;

import com.example.tutosSpringBoot.data.entities.Command;
import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.entities.Product;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CommandReactiveService2 {
    public Mono<Command> addCommand(Long personId, Long productId, int items){
        Person person = new Person();
        person.setId(personId);

        Product product = new Product();
        product.setId(productId);

        Command command = new Command();
        command.setPerson(person);
        command.setProduct(product);
        command.setItems(items);
        return null;//repository.save(command);
    }

    public Mono<Command> findById(long id){
        return null;//repository.findById(id);
    }

    public Flux<Command> findAll(){
        return null;//repository.findAll();
    }
}
