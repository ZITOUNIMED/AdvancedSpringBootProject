package com.example.tutosSpringBoot.rest;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.GenericEntity;
import com.example.tutosSpringBoot.data.services.ICrudService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

abstract public class AbstractRestController<S extends GenericEntity> {

    public abstract ICrudService<S> getService();

    @PostMapping("/create")
    public ResponseEntity<S> create(@RequestBody S entity){
        entity.setId(null);
        getService().save(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<S>> findAll(){
       return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<S> findById(@PathVariable Long id){
        S s = getService().findById(id).orElse(null);
       return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
