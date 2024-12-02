package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text, Double rating, Long locationId);

    void saveEvent(String name, String description, Double popularityScore, Long locationId);

    void deleteById(Long id);

    void editEvent(Long eventId, String name, String description, Double popularityScore, Long locationId);

    Optional<Event> findByIdOptional(Long eventId);
}