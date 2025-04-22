package org.example.Domain.Events;


import org.springframework.context.ApplicationEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class FeedingTimeEvent extends ApplicationEvent {
    private final UUID animalId;
    private final LocalDateTime time;

    public FeedingTimeEvent(Object source, UUID animalId, LocalDateTime time) {
        super(source);
        this.animalId = animalId;
        this.time = time;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public LocalDateTime getTime() {
        return time;
    }
}