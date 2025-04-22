package org.example.Domain.Events;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class AnimalMovedEvent extends ApplicationEvent {
    private final UUID animalId;
    private final UUID fromEnclosureId;
    private final UUID toEnclosureId;

    public AnimalMovedEvent(Object source, UUID animalId, UUID fromEnclosureId, UUID toEnclosureId) {
        super(source);
        this.animalId = animalId;
        this.fromEnclosureId = fromEnclosureId;
        this.toEnclosureId = toEnclosureId;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public UUID getFromEnclosureId() {
        return fromEnclosureId;
    }

    public UUID getToEnclosureId() {
        return toEnclosureId;
    }
}
