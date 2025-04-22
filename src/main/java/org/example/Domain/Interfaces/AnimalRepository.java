package org.example.Domain.Interfaces;

import org.example.Domain.Animal;

import java.util.*;

public interface AnimalRepository {
    void save(Animal animal);
    Optional<Animal> findById(UUID id);
    Collection<Animal> findAll();
    void delete(UUID id);
}