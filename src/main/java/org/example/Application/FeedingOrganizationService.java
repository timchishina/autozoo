package org.example.Application;

import org.example.Infrastructure.InMemoryAnimalRepository;
import org.example.Infrastructure.InMemoryFeedingScheduleRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class FeedingOrganizationService {
    private final InMemoryAnimalRepository animalRepo;
    private final InMemoryFeedingScheduleRepository feedingRepo;
    private final ApplicationEventPublisher eventPublisher;

    public FeedingOrganizationService(InMemoryAnimalRepository animalRepo, InMemoryFeedingScheduleRepository feedingRepo, ApplicationEventPublisher eventPublisher) {
        this.animalRepo = animalRepo;
        this.feedingRepo = feedingRepo;
        this.eventPublisher = eventPublisher;
    }

    public String feed(UUID scheduleId) {
        var scheduleOpt = feedingRepo.findById(scheduleId);
        if (scheduleOpt.isEmpty()) return "Расписание не найдено";

        var schedule = scheduleOpt.get();
        if (schedule.isDone()) return "Уже покормлено";

        var animalOpt = animalRepo.findById(schedule.getAnimalId());
        if (animalOpt.isEmpty()) return "Животное не найдено";

        var animal = animalOpt.get();
        animal.feed();
        schedule.markAsDone();
        feedingRepo.save(schedule);

        eventPublisher.publishEvent(new org.example.Domain.Events.FeedingTimeEvent(this, animal.getId(), LocalDateTime.now()));
        return "Животное покормлено";
    }
}