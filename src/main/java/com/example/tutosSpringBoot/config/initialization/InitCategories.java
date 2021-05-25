package com.example.tutosSpringBoot.config.initialization;

import java.util.stream.Stream;

import com.example.tutosSpringBoot.data.entities.Category;
import com.example.tutosSpringBoot.data.services.impl.CategoriesService;
import com.example.tutosSpringBoot.utils.CategoriesEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitCategories implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitCategories.class);

    @Autowired
    private CategoriesService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Init categories ...");

        Stream.of(CategoriesEnum.CHEAP_PRODUCTS.getRef(), 
            CategoriesEnum.EXPENSIVEE_PRODUCTS.getRef(),
            CategoriesEnum.TOO_EXPENSIVE_PRODUCTS.getRef()
        )
        .peek(categoryName -> {
            LOGGER.info("Add New Category, Name: " + categoryName);
        })
        .map(categoryName -> {
            Category c = new Category();
            c.setName(categoryName);
            return c;
        })
        .forEach(service::save);
    }
}
