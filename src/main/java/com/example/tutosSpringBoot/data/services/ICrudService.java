package com.example.tutosSpringBoot.data.services;

import java.util.List;
import java.util.Optional;

public interface ICrudService<S>{
    S save(S entity);

    Optional<S> findById(Long id);

    boolean existsById(Long id);

    List<S> findAll();

    long count();

    void deleteById(Long id);

    void deleteAll();
}
