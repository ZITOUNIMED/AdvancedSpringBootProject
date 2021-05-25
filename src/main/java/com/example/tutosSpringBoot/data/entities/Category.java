package com.example.tutosSpringBoot.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category extends GenericEntity {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;
    private String name;
}
