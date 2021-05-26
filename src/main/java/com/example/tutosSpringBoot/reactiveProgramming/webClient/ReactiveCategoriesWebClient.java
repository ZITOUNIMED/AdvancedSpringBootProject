package com.example.tutosSpringBoot.reactiveProgramming.webClient;

import java.util.List;

import com.example.tutosSpringBoot.data.entities.Category;

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
@Order(7)
public class ReactiveCategoriesWebClient implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsReactiveWebClient.class);
    private final String url = "/categories";
    
    @Autowired
    private WebClient webClient;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Reactive Categories Web Client ...");
        Flux<Category> response = webClient.get()
            .uri(url)
            .header("Authorization", "Bearer " + ConnectedUser.getToken())
            .retrieve()
            .bodyToFlux(Category.class);

        Mono<List<Category>> monoResult = response.collectList();
        System.out.println(monoResult.block());
    }
}
