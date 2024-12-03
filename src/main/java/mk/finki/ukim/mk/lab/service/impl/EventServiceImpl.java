package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.exception.EventNotFoundException;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationService locationService;

    public EventServiceImpl(EventRepository eventRepository, LocationService locationService) {
        this.eventRepository = eventRepository;
        this.locationService = locationService;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String name, Double rating, Long locationId) {
            return eventRepository.filterEvents(name, rating, locationId);


    }

    @Override
    public void saveEvent(String name, String description, Double popularityScore, Long locationId) {
        Location location = this.locationService.findById(locationId);
        Event event = new Event(name, description, popularityScore, location);
        this.eventRepository.save(event);

    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public void editEvent(Long eventId, String name, String description, Double popularityScore, Long locationId) {
        Location location = this.locationService.findById(locationId);
        Event event = findById(eventId);
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
        this.eventRepository.save(event);
    }

    @Override
    public Optional<Event> findByIdOptional(Long eventId) {

        return eventRepository.findById(eventId);
    }

    private Event findById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event with id: " + eventId + " was not found"));
    }
}
