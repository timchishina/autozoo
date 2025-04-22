package org.example.Domain.Interfaces;

import org.example.Domain.FeedingSchedule;

import java.util.*;

public interface FeedingScheduleRepository {
    void save(FeedingSchedule schedule);
    Optional<FeedingSchedule> findById(UUID id);
    Collection<FeedingSchedule> findAll();
    void delete(UUID id);
}