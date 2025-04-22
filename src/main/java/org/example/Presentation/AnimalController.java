package org.example.Presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.Domain.Animal;
import org.example.Domain.ValueObjects.*;
import org.example.Domain.Interfaces.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/animals")
@Tag(name = "Животные", description = "Управление животными в зоопарке")
public class AnimalController {
    private final AnimalRepository repo;

    public AnimalController(AnimalRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Получить всех животных")
    @GetMapping
    public Collection<Animal> getAll() {
        return repo.findAll();
    }

    @Operation(summary = "Добавить животное")
    @PostMapping
    public ResponseEntity<String> addAnimal(@RequestBody AnimalDTO dto) {
        Animal animal = new Animal(
                UUID.randomUUID(),
                new AnimalName(dto.name()),
                new Species(dto.species()),
                dto.birthDate(),
                new Gender(dto.gender()),
                new FoodType(dto.favoriteFood())
        );
        repo.save(animal);
        return ResponseEntity.ok("Добавлено");
    }

    @Operation(summary = "Удалить животное")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable UUID id) {
        repo.delete(id);
        return ResponseEntity.ok("Удалено");
    }

    public record AnimalDTO(String name, String species, LocalDate birthDate, String gender, String favoriteFood) {}
}