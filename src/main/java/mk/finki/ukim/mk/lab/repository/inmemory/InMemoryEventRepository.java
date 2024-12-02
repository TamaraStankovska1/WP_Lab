package mk.finki.ukim.mk.lab.repository.inmemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.exception.EventNotFoundException;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryEventRepository {


    public List<Event> findAll() {
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text, Integer rating) {
        if(text == null || rating == null){
            return DataHolder.events;
        }
        return DataHolder.events.stream()
                .filter(x -> (x.getName().contains(text) || x.getDescription().contains(text))
                        && (x.getPopularityScore() >= rating))
                .collect(Collectors.toList());
    }

    public void save(String name, String description, Double popularityScore, Location location) {
        if (location == null) {
            throw new IllegalArgumentException();
        }

        Event event = new Event(name, description, popularityScore, location);
        DataHolder.events.removeIf(p -> p.getName().equals(event.getName()));
        DataHolder.events.add(event);
    }

    public void deleteById(Long id) {
        DataHolder.events.removeIf(i -> i.getId().equals(id));
    }


    public void edit(Long eventId, String name, String description, Double popularityScore, Location location) {
        Event event = findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event with id: " + eventId + " was not found"));
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);
    }

    public Optional<Event> findById(Long eventId) {
        return DataHolder.events.stream().filter(x -> x.getId().equals(eventId)).findAny();
    }
}
