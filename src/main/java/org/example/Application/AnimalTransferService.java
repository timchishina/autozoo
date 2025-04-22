package org.example.Application;

import org.example.Domain.Enclosure;
import org.example.Domain.Events.AnimalMovedEvent;
import org.example.Infrastructure.InMemoryEnclosureRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AnimalTransferService {
    private final InMemoryEnclosureRepository enclosureRepo;
    private final ApplicationEventPublisher eventPublisher;

    public AnimalTransferService(InMemoryEnclosureRepository enclosureRepo, ApplicationEventPublisher eventPublisher) {
        this.enclosureRepo = enclosureRepo;
        this.eventPublisher = eventPublisher;

    }
    public String transferAnimal(UUID animalId, UUID fromEnclosureId, UUID toEnclosureId) {
        var fromOpt = enclosureRepo.findById(fromEnclosureId);
        var toOpt = enclosureRepo.findById(toEnclosureId);
        if (fromOpt.isEmpty() || toOpt.isEmpty()) {
            return "Один из вольеров не найден";
        }
        Enclosure from = fromOpt.get();
        Enclosure to = toOpt.get();
        if (!from.getAnimalIds().contains(animalId)) {
            return "Животное не найдено в указанном вольере";
        }
        if (!to.addAnimal(animalId)) {
            return "Целевой вольер переполнен";
        }
        from.removeAnimal(animalId);
        eventPublisher.publishEvent(new AnimalMovedEvent(this, animalId, from.getId(), to.getId()));
        return "Животное перемещено успешно";
    }
}
