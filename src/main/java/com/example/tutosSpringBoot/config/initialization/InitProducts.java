package com.example.tutosSpringBoot.config.initialization;

import java.util.stream.Stream;

import com.example.tutosSpringBoot.data.entities.Product;
import com.example.tutosSpringBoot.data.services.impl.ProductsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class InitProducts implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitProducts.class);
    private int counter = 0;

    @Autowired
    private ProductsService productsService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Init products ...");

        Stream.of(0.55f, 0.76f, 0.99f, 1f, 2.5f, 10f, 50f, 87f, 200, 500f, 1_000f, 5_000.0f, 10_000.0f, 50_000f, 100_000f)
        .map(price -> {
            Product p = new Product();
            p.setPrice(price.floatValue());
            p.setRef("Product " + ++this.counter);
            return p;
        })
        .peek(p -> {
            LOGGER.info("Add New Product, Ref: " + p.getRef());
        })
        .forEach(productsService::save);
    }
    
}
