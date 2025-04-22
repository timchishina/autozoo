package org.example.Domain;

import org.example.Domain.ValueObjects.EnclosureType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Enclosure {
    private final UUID id;
    private final EnclosureType type;
    private final int capacity;
    private final List<UUID> animalIds = new ArrayList<>();

    public Enclosure(UUID id, EnclosureType type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    public boolean addAnimal(UUID animalId) {
        if (animalIds.size() < capacity) {
            animalIds.add(animalId);
            return true;
        }
        return false;
    }

    public void removeAnimal(UUID animalId) {
        animalIds.remove(animalId);
    }

    public void clean() {
        System.out.println("Enclosure " + id + " cleaned");
    }

    public UUID getId() {
        return id;
    }

    public EnclosureType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentCount() {
        return animalIds.size();
    }

    public List<UUID> getAnimalIds() {
        return animalIds;
    }
}