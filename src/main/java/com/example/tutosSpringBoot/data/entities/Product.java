package com.example.tutosSpringBoot.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends GenericEntity{
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String ref;
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString(){
        return "Product{id: "+id+", ref: '"+ref+"', price: "+price+"}";
    }
}
