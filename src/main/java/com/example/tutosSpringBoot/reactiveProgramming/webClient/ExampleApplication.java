package com.example.tutosSpringBoot.reactiveProgramming.webClient;

import com.example.tutosSpringBoot.data.entities.Product;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExampleApplication {
    public static void main(String[] args) {

        WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080/api/open/products")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
        
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° Last Product °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println(getLastProduct(webClient));
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        
        Product bycle = new Product();
        bycle.setPrice(1400);
        bycle.setRef("Bycle");
        addProduct(webClient, bycle);

        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° Last Product °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println(getLastProduct(webClient));
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        
    }

    public static Product addProduct(WebClient webClient, Product p){
        return webClient.post()
        .uri("/create")
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(Mono.just(p), Product.class)
        .retrieve()
        .bodyToMono(Product.class)
        .block();
    }

    public static Product getLastProduct(WebClient webClient){
        Flux<Product> response = webClient.get()
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Product.class);

        return response.last().block();
    }

    /*

    Mono<Product[]> response1 = webClient.get()
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(Product[].class);
        //.log();

        Product[] products1 = response1.block();
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° Products 1 °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println("Products 1 length: " + products1.length);
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° Products 2 °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        Product[] products2 = response1.block();
        System.out.println("Products 2 length: " + products2.length);
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        Flux<Product> response2 = webClient.get()
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToFlux(Product.class);

        Mono<Product> monoProduct = response2.next(); // response2.first()
        Product product = monoProduct.block();
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° First Product °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println(product);
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

    */
}
