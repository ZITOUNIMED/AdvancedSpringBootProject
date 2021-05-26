package com.example.tutosSpringBoot.reactiveProgramming.webClient;

import com.example.tutosSpringBoot.rest.requests.LoginRequest;
import com.example.tutosSpringBoot.rest.responses.AuthResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
@Order(6)
public class ReactiveAuthenticationWebClient implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsReactiveWebClient.class);
    private final String url = "/open/auth";
    
    @Autowired
    private WebClient webClient;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Reactive Authentication ...");
        LoginRequest request = new LoginRequest();
        request.setEmail("admin@gmail.com");
        request.setPassword("admin");

        AuthResponse authResponse = webClient.post()
            .uri(url + "/login")
            .body(Mono.just(request), LoginRequest.class)
            .retrieve()
            .bodyToMono(AuthResponse.class)
            .block();

        ConnectedUser.setAuthData(authResponse);
    }
}
