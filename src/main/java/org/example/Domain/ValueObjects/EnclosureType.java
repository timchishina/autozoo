package org.example.Domain.ValueObjects;


import java.util.Objects;

public class EnclosureType {
    private final String value;

    public EnclosureType(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Тип вольера не может быть пустым");
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
        EnclosureType that = (EnclosureType) o;
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
