package com.example.tutosSpringBoot.utils;

public enum CategoriesEnum {
    CHEAP_PRODUCTS("Cheap Products"),
    EXPENSIVEE_PRODUCTS("Expensive Products"),
    TOO_EXPENSIVE_PRODUCTS("Too Expensive Products");

    private String ref;
    CategoriesEnum(String ref){
        this.ref = ref;
    }

    public String getRef(){
        return ref;
    }
}
