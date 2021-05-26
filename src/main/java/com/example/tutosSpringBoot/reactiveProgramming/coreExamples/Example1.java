package com.example.tutosSpringBoot.reactiveProgramming.coreExamples;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example1 {
    public static void main(String[] args) {
        Mono<String> just2 = Mono.just("foo");
        System.out.println(just2.block()); // foo

        Flux<Integer> justIntegers = Flux.just(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

        Mono<Integer> firstMono = justIntegers.next();
        Integer firstInteger = firstMono.block();
        System.out.println(firstInteger); // 10
        System.out.println(justIntegers.last().block()); // 100

        Mono<List<Integer>> monoInteger = justIntegers.collectList();

        List<Integer> elements = monoInteger.block();
        System.out.println(elements); // [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

        Flux.just(101, 102, 103, 104, 105, 106, 107)
        // .log() 18:35:23.942 [main] INFO reactor.Flux.Array.1 - | onNext(103)
        .subscribe(System.out::println); // print on console each element

        Flux.just(101, 102, 103, 104, 105, 106, 107)
        .subscribe(element -> {
            System.out.println(element);// print on console each element
        }); 

        Flux.just(101, 102, 103, 104, 105, 106, 107)
        .subscribe(elements::add); // add each element to the list
        
        System.out.println(elements); // 10, 20,..., 104, 105, 106, 107]
    }
}
