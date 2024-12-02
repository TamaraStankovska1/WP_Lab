package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @PostMapping
    public String bookEvent(HttpServletRequest request,
                            @RequestParam String eventName,
                            @RequestParam Integer numTickets,
                            Model model) {
        EventBooking eventBooking = eventBookingService.placeBooking(eventName, "Tamara", request.getRemoteAddr(), numTickets);
        model.addAttribute("eventBooking", eventBooking);
        return "bookingConfirmation";
    }
    @PostMapping("/details/{id}")
    public String DetailsForEvent(@PathVariable Long id){
        this.eventService.findByIdOptional(id);
        return "bookingConfirmation";
    }
}
