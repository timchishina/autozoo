package org.example.Domain;

import org.example.Domain.ValueObjects.*;

import java.time.LocalDate;
import java.util.UUID;

public class Animal {
    private final UUID id;
    private final AnimalName name;
    private final Species species;
    private final LocalDate birthDate;
    private final Gender gender;
    private final FoodType favoriteFood;
    private String healthStatus;

    public Animal(UUID id, AnimalName name, Species species, LocalDate birthDate, Gender gender, FoodType favoriteFood) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.birthDate = birthDate;
        this.gender = gender;
        this.favoriteFood = favoriteFood;
        this.healthStatus = "healthy";
    }

    public void feed() {
        System.out.println(name + " is fed with " + favoriteFood);
    }

    public void heal() {
        this.healthStatus = "healthy";
    }

    public UUID getId() {
        return id;
    }

    public AnimalName getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public FoodType getFavoriteFood() {
        return favoriteFood;
    }

    public String getHealthStatus() {
        return healthStatus;
    }
}