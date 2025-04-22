package org.example.Application;

import org.example.Infrastructure.InMemoryAnimalRepository;
import org.example.Infrastructure.InMemoryEnclosureRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZooStatisticsService {
    private final InMemoryAnimalRepository animalRepo;
    private final InMemoryEnclosureRepository enclosureRepo;

    public ZooStatisticsService(InMemoryAnimalRepository animalRepo, InMemoryEnclosureRepository enclosureRepo) {
        this.animalRepo = animalRepo;
        this.enclosureRepo = enclosureRepo;
    }

    public Map<String, Object> getZooStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalAnimals", animalRepo.findAll().size());
        stats.put("totalEnclosures", enclosureRepo.findAll().size());
        long freeEnclosures = enclosureRepo.findAll().stream()
                .filter(enc -> enc.getCurrentCount() < enc.getCapacity())
                .count();
        stats.put("freeEnclosures", freeEnclosures);
        return stats;
    }
}