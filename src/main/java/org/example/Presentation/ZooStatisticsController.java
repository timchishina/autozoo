package org.example.Presentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.Application.ZooStatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
@Tag(name = "Статистика", description = "Общая статистика по зоопарку")
public class ZooStatisticsController {
    private final ZooStatisticsService service;

    public ZooStatisticsController(ZooStatisticsService service) {
        this.service = service;
    }

    @Operation(summary = "Получить статистику по зоопарку")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getStats() {
        return ResponseEntity.ok(service.getZooStats());
    }
}