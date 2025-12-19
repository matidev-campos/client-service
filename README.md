# Client Service

Microservice responsible for client management.

It is part of an event-driven architecture, communicating with other services via RabbitMQ

---

## 📌 Responsabilities

- Create clients

- Update clients

- Delete clients

- Publish domain events when a client's state changes

---

## 📦 Published events

This service publishes events to RabbitMQ for other services to react to:

| Evento | Descripción |
|------|-------------|
| client.created | Cliente creado |
| client.deleted | Cliente eliminado |

Estos eventos son consumidos por `account-service`.

---

## 🐇 RabbitMQ

El servicio actúa como **producer** de eventos.

### Exchanges
- `client.events.exchange` (topic)

### Routing keys
- `client.created`
- `client.deleted`

---

## 🧱 Arquitectura

- Spring Boot
- JPA / Hibernate
- RabbitMQ (Spring AMQP)
- Arquitectura hexagonal / clean
- Publicación de eventos desacoplada de la lógica de negocio

---

## 🚀 Ejecución

---

## Testing

The service includes unit tests using **JUnit 5** and **Mockito**.

### Covered Scenarios
- Publishing `ClientCreatedEvent` when a client is created

Tests can be executed with:

```bash
mvn test
