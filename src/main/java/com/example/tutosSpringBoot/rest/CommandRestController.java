package com.example.tutosSpringBoot.rest;

import com.example.tutosSpringBoot.data.entities.Command;
import com.example.tutosSpringBoot.data.services.CommandReactiveService2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/commands")
public class CommandRestController {
    @Autowired
    private CommandReactiveService2 service;

    @PostMapping("/add/{personId}/{productId)/{items}")
    public Mono<Command> addCommand(@PathVariable("personId") Long personId,
        @PathVariable("productId") Long productId, 
        @PathVariable("items") Integer items){
        return service.addCommand(personId, productId, items);
    }

    @GetMapping("/{id}")
    public Mono<Command> findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public Flux<Command> findAll(){
        return service.findAll();
    }
}
