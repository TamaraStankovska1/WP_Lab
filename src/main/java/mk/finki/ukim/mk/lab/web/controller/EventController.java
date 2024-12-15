package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }


    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String filterName,
                                @RequestParam(required = false) Double filterRating,
                                @RequestParam(required = false) Long locationId,
                                @RequestParam(required = false) String error,
                                Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Event> events = eventService.searchEvents(filterName, filterRating, locationId);
        List<Location> locations = locationService.findAll();
        model.addAttribute("events", events);
        model.addAttribute("locations", locations);
        return "listEvents";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Long locationId) {
        eventService.saveEvent(name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @PostMapping("/edit/{eventId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editEvent(@PathVariable Long eventId,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Long locationId) {
        eventService.editEvent(eventId, name, description, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("/edit-form/{eventId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String getEditEventForm(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventService.findByIdOptional(eventId);
        if (event.isEmpty()) {
            return "redirect:/events?error=EventNotFound";
        }
        List<Location> locations = locationService.findAll();
        model.addAttribute("event", event.get());
        model.addAttribute("locations", locations);
        return "addEvent";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ADMIN')")
    public String addEvent(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "addEvent";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEvent(@PathVariable Long id) {
        this.eventService.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/details/{eventId}")
    public String getEventDetails(@PathVariable long eventId, Model model) {
        Optional<Event> event = eventService.findByIdOptional(eventId);
        if (event.isEmpty()) {
            return "redirect:/events?error=EventNotFound";
        }
        model.addAttribute("event", event.get());
        return "details";
    }
}
