package com.example.tutosSpringBoot.rest;

import com.example.tutosSpringBoot.data.entities.Category;
import com.example.tutosSpringBoot.data.services.ICrudService;
import com.example.tutosSpringBoot.data.services.impl.CategoriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController extends AbstractRestController<Category>{
    @Autowired
    private CategoriesService service;

    @Override
    public ICrudService<Category> getService() {
        return service;
    }
}
