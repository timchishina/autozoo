package org.example.Domain.Interfaces;

import org.example.Domain.Enclosure;

import java.util.*;

public interface EnclosureRepository {
    void save(Enclosure enclosure);
    Optional<Enclosure> findById(UUID id);
    Collection<Enclosure> findAll();
    void delete(UUID id);
}