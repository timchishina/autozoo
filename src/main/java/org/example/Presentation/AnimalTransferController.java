package org.example.Presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.Application.AnimalTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/transfer")
@Tag(name = "Перемещение животных", description = "Перемещение животных между вольерами")
public class AnimalTransferController {
    private final AnimalTransferService service;
    public AnimalTransferController(AnimalTransferService service) {
        this.service = service;
    }
    @Operation(summary = "Переместить животное между вольерами")
    @PostMapping
    public ResponseEntity<String> transfer(@RequestBody TransferDTO dto) {
        return ResponseEntity.ok(service.transferAnimal(dto.animalId(), dto.fromEnclosureId(), dto.toEnclosureId()));
    }
    public record TransferDTO(UUID animalId, UUID fromEnclosureId, UUID toEnclosureId) {}
}
