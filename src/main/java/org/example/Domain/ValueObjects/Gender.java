package org.example.Domain.ValueObjects;

import java.util.Objects;

public class Gender {
    private final String value;

    public Gender(String value) {
        if (!value.equals("male") && !value.equals("female")) {
            throw new IllegalArgumentException("Пол должен быть 'male' или 'female'");
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
        Gender gender = (Gender) o;
        return Objects.equals(value, gender.value);
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