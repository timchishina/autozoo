package org.example.Presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.Application.FeedingOrganizationService;
import org.example.Domain.FeedingSchedule;
import org.example.Domain.Interfaces.FeedingScheduleRepository;
import org.example.Domain.ValueObjects.FoodType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/feeding")
@Tag(name = "Кормление", description = "Управление расписанием кормления")
public class FeedingScheduleController {
    private final FeedingScheduleRepository repo;
    private final FeedingOrganizationService feedingService;

    public FeedingScheduleController(FeedingScheduleRepository repo, FeedingOrganizationService feedingService) {
        this.repo = repo;
        this.feedingService = feedingService;
    }

    @Operation(summary = "Посмотреть расписание кормлений")
    @GetMapping
    public Collection<FeedingSchedule> getAll() {
        return repo.findAll();
    }

    @Operation(summary = "Добавить кормление в расписание")
    @PostMapping
    public ResponseEntity<String> addSchedule(@RequestBody FeedingDTO dto) {
        FeedingSchedule schedule = new FeedingSchedule(dto.animalId(), dto.feedingTime(), new FoodType(dto.foodType()));
        repo.save(schedule);
        return ResponseEntity.ok("Кормление добавлено");
    }

    @Operation(summary = "Покормить животное по расписанию")
    @PostMapping("/feed/{scheduleId}")
    public ResponseEntity<String> feedAnimal(@PathVariable UUID scheduleId) {
        return ResponseEntity.ok(feedingService.feed(scheduleId));
    }

    public record FeedingDTO(UUID animalId, LocalDateTime feedingTime, String foodType) {}
}
