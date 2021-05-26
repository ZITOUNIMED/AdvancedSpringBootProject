package com.example.tutosSpringBoot.rest.open;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.Product;
import com.example.tutosSpringBoot.data.services.ICrudService;
import com.example.tutosSpringBoot.data.services.impl.ProductsService;
import com.example.tutosSpringBoot.rest.AbstractRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/open/products")
public class ProductsController extends AbstractRestController<Product>{
    @Autowired
    private ProductsService service;

    @GetMapping("/cheap-products")
    public ResponseEntity<List<Product>> findCheapProducts(){
       return new ResponseEntity<>(service.findCheapProducts(), HttpStatus.OK);
    }

    @GetMapping("/expensive-products")
    public ResponseEntity<List<Product>> findExpensiveProducts(){
       return new ResponseEntity<>(service.findExpensiveProducts(), HttpStatus.OK);
    }

    @GetMapping("/too-expensive-products")
    public ResponseEntity<List<Product>> findTooExpensiveProducts(){
       return new ResponseEntity<>(service.findTooExpensiveProducts(), HttpStatus.OK);
    }

    @Override
    public ICrudService<Product> getService() {
        return service;
    }
}
