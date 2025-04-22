package org.example.Presentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.Domain.Enclosure;
import org.example.Domain.Interfaces.EnclosureRepository;
import org.example.Domain.ValueObjects.EnclosureType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/enclosures")
@Tag(name = "Вольеры", description = "Управление вольерами")
public class EnclosureController {
    private final EnclosureRepository repo;

    public EnclosureController(EnclosureRepository repo) {
        this.repo = repo;
    }

    @Operation(summary = "Посмотреть все вольеры")
    @GetMapping
    public Collection<Enclosure> getAll() {
        return repo.findAll();
    }

    @Operation(summary = "Добавить вольер")
    @PostMapping
    public ResponseEntity<String> add(@RequestBody EnclosureDTO dto) {
        Enclosure enc = new Enclosure(UUID.randomUUID(), new EnclosureType(dto.type()), dto.capacity());
        repo.save(enc);
        return ResponseEntity.ok("Вольер добавлен");
    }

    @Operation(summary = "Удалить вольер")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        repo.delete(id);
        return ResponseEntity.ok("Удалено");
    }

    @Operation(summary = "Провести уборку в вольере")
    @PostMapping("/clean/{id}")
    public ResponseEntity<String> clean(@PathVariable UUID id) {
        var encOpt = repo.findById(id);
        if (encOpt.isEmpty()) return ResponseEntity.badRequest().body("Не найдено");
        encOpt.get().clean();
        return ResponseEntity.ok("Уборка выполнена");
    }

    public record EnclosureDTO(String type, int capacity) {}
}