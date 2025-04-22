package org.example.Infrastructure;

import org.example.Domain.FeedingSchedule;
import org.example.Domain.Interfaces.FeedingScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class InMemoryFeedingScheduleRepository implements FeedingScheduleRepository {
    private final Map<UUID, FeedingSchedule> schedules = new HashMap<>();

    @Override
    public void save(FeedingSchedule schedule) {
        schedules.put(schedule.getId(), schedule);
    }

    @Override
    public Optional<FeedingSchedule> findById(UUID id) {
        return Optional.ofNullable(schedules.get(id));
    }

    @Override
    public Collection<FeedingSchedule> findAll() {
        return schedules.values();
    }

    @Override
    public void delete(UUID id) {
        schedules.remove(id);
    }
}