package org.example.Infrastructure;

import org.example.Domain.Animal;
import org.example.Domain.Interfaces.AnimalRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryAnimalRepository implements AnimalRepository {
    private final Map<UUID, Animal> animals = new HashMap<>();

    @Override
    public void save(Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @Override
    public Optional<Animal> findById(UUID id) {
        return Optional.ofNullable(animals.get(id));
    }

    @Override
    public Collection<Animal> findAll() {
        return animals.values();
    }

    @Override
    public void delete(UUID id) {
        animals.remove(id);
    }
}
