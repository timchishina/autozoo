package org.example.Domain;
import org.example.Domain.ValueObjects.FoodType;

import java.time.LocalDateTime;
import java.util.UUID;

public class FeedingSchedule {
    private final UUID id;
    private final UUID animalId;
    private LocalDateTime feedingTime;
    private FoodType foodType;
    private boolean done;

    public FeedingSchedule(UUID animalId, LocalDateTime feedingTime, FoodType foodType) {
        this.id = UUID.randomUUID();
        this.animalId = animalId;
        this.feedingTime = feedingTime;
        this.foodType = foodType;
        this.done = false;
    }

    public void reschedule(LocalDateTime newTime) {
        this.feedingTime = newTime;
    }

    public void markAsDone() {
        this.done = true;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAnimalId() {
        return animalId;
    }

    public LocalDateTime getFeedingTime() {
        return feedingTime;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public boolean isDone() {
        return done;
    }
}

