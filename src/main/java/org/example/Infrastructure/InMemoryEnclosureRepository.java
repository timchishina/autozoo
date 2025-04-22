package org.example.Infrastructure;

import org.example.Domain.Enclosure;
import org.example.Domain.Interfaces.EnclosureRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryEnclosureRepository implements EnclosureRepository {
    private final Map<UUID, Enclosure> enclosures = new HashMap<>();

    @Override
    public void save(Enclosure enclosure) {
        enclosures.put(enclosure.getId(), enclosure);
    }

    @Override
    public Optional<Enclosure> findById(UUID id) {
        return Optional.ofNullable(enclosures.get(id));
    }

    @Override
    public Collection<Enclosure> findAll() {
        return enclosures.values();
    }

    @Override
    public void delete(UUID id) {
        enclosures.remove(id);
    }
}