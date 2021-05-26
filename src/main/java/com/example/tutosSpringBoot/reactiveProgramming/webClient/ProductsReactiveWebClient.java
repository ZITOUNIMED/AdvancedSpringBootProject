package com.example.tutosSpringBoot.reactiveProgramming.webClient;

import com.example.tutosSpringBoot.data.entities.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Order(5)
public class ProductsReactiveWebClient implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsReactiveWebClient.class);
    private final String url = "/open/products";
    
    @Autowired
    private WebClient webClient;

    @Override
    public void run(String... args) throws Exception {
       LOGGER.info("Products Reactive WebClient ....");
       Product bycle = new Product();
        bycle.setPrice(1400);
        bycle.setRef("Bycle");
        addProduct(bycle);

        System.out.println(getLastProduct());
    }
    
    private Product addProduct(Product p){
        return webClient.post()
        .uri(url + "/create")
        .body(Mono.just(p), Product.class)
        .retrieve()
        .bodyToMono(Product.class)
        .block();
    }

    public Product getLastProduct(){
        Flux<Product> response = webClient.get()
        .uri(url)
        .retrieve()
        .bodyToFlux(Product.class);

        return response.last().block();
    }
}
