package com.example.tutosSpringBoot.data.entities;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class Command {
    //@Id
    //@GeneratedValue
    private Long id;

    private Person person;
    private Product product;
    private int items;
}
