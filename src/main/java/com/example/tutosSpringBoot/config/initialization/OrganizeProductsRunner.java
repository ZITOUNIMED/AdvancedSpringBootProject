package com.example.tutosSpringBoot.config.initialization;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.Category;
import com.example.tutosSpringBoot.data.entities.Product;
import com.example.tutosSpringBoot.data.services.impl.CategoriesService;
import com.example.tutosSpringBoot.data.services.impl.ProductsService;
import com.example.tutosSpringBoot.utils.CategoriesEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class OrganizeProductsRunner implements CommandLineRunner{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizeProductsRunner.class);

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private ProductsService productsService;
    
    @Override
    public void run(String... args) throws Exception {
       LOGGER.info("Organize Products ...");
       List<Category> categories1 = categoriesService.findByName(CategoriesEnum.CHEAP_PRODUCTS.getRef());
       if(categories1 != null && categories1.size()>0){
           Category cheapCategory = categories1.get(0);

           List<Product> products = productsService.findByPriceLessThan(1000f);
           if(products != null){
              LOGGER.info("Cheap Products: " + products.size());
              products.stream()
              .peek(product -> {
                  product.setCategory(cheapCategory);
              })
              .forEach(productsService::save);
           }
       }

       List<Category> categories2 = categoriesService.findByName(CategoriesEnum.EXPENSIVEE_PRODUCTS.getRef());
       if(categories2 != null && categories2.size()>0){
           Category expensiveCategory = categories2.get(0);

           List<Product> products = productsService.findByPriceBetween(1_000f, 10_000f);
           if(products != null){
              LOGGER.info("Expensive Products: " + products.size());
              products.stream()
              .peek(product -> {
                  product.setCategory(expensiveCategory);
              })
              .forEach(productsService::save);
           }
       }

       List<Category> categories3 = categoriesService.findByName(CategoriesEnum.TOO_EXPENSIVE_PRODUCTS.getRef());
       if(categories3 != null && categories3.size()>0){
           Category tooExpensiveCategory = categories3.get(0);

           List<Product> products = productsService.findByPriceGreaterThan(10_000f);
           if(products != null){
              LOGGER.info("Too Expensive Products: " + products.size());
              products.stream()
              .peek(product -> {
                  product.setCategory(tooExpensiveCategory);
              })
              .forEach(productsService::save);
           }
       }
    }
    
}
