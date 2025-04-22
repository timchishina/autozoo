package org.example.Domain.ValueObjects;

import java.util.Objects;

public class AnimalName {
    private final String value;

    public AnimalName(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Имя животного не может быть пустым");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalName that = (AnimalName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}