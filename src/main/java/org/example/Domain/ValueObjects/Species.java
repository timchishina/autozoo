package org.example.Domain.ValueObjects;

import java.util.Objects;

public class Species {
    private final String value;

    public Species(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Вид не может быть пустым");
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
        Species species = (Species) o;
        return Objects.equals(value, species.value);
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
