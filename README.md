# AutoZoo — Информационная система зоопарка

## Использованные Технологии

- Java 17
- Spring Boot 3
- Maven
- REST API
- Swagger (OpenAPI)
- In-memory хранилища (без БД)

---

## Архитектура проекта
<pre lang="text"><code>org.example
├── Application/                # Бизнес-логика (сервисы)
│   ├── AnimalTransferService.java
│   ├── FeedingOrganizationService.java
│   └── ZooStatisticsService.java
│
├── Domain/                    # Доменные модели и Value Objects
│   ├── Animal.java
│   ├── Enclosure.java
│   ├── FeedingSchedule.java
│   ├── Interfaces/            # Интерфейсы репозиториев
│   │   ├── AnimalRepository.java
│   │   ├── EnclosureRepository.java
│   │   └── FeedingScheduleRepository.java
│   ├── Events/                # Domain-события
│   │   ├── FeedingTimeEvent.java
│   │   └── AnimalMovedEvent.java
│   └── ValueObjects/          # Value Object'ы
│       ├── AnimalName.java
│       ├── EnclosureType.java
│       ├── FoodType.java
│       ├── Gender.java
│       └── Species.java
│
├── Infrastructure/           # Реализация репозиториев
│   ├── InMemoryAnimalRepository.java
│   ├── InMemoryEnclosureRepository.java
│   └── InMemoryFeedingScheduleRepository.java
│
├── Presentation/             # REST API контроллеры
│   ├── AnimalController.java
│   ├── AnimalTransferController.java
│   ├── EnclosureController.java
│   ├── FeedingScheduleController.java
│   └── ZooStatisticsController.java
│
└── Main.java                 # Точка входа (с @SpringBootApplication)
</code></pre>

Все зависимости направлены **внутрь**:
- `presentation` зависит от `application`
- `application` зависит от `domain`
- `infrastructure` реализует интерфейсы из `domain/application`
## Для запуска необходимо убедиться

- что установлен **JDK 17** и **Maven**
- выполнить команду:
```bash
mvn spring-boot:run
```
И перейти в браузер по ссылке

http://localhost:8080/swagger-ui/index.html