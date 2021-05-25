package com.example.tutosSpringBoot.rest;

import com.example.tutosSpringBoot.data.entities.Person;
import com.example.tutosSpringBoot.data.services.ICrudService;
import com.example.tutosSpringBoot.data.services.impl.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonsController extends AbstractRestController<Person>{
    @Autowired
    private PersonService service;

    @Override
    public ICrudService<Person> getService() {
        return service;
    }
}
