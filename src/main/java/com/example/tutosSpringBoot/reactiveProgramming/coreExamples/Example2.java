package com.example.tutosSpringBoot.reactiveProgramming.coreExamples;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Example2 {
    public static void main(String[] args) {
        Integer[] data1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] data2 = {10, 20, 30, 40, 50, 60, 70};

        Flux.just(data1)
        .zipWith(Flux.just(data2))
        .subscribe(System.out::println); // [1,10] ...

        List<Integer> elements = new ArrayList<>();
        // Concurrency
        Flux.range(1, 50)
            .map(i -> i * 2)
            .subscribeOn(Schedulers.parallel())
            .log()
            .subscribe(elements::add);
            System.out.println(elements); // [] ???
    }
}
