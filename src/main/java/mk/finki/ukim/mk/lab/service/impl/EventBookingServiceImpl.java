package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    EventBooking eventBooking;

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName,
                                     String attendeeAddress, Integer numberOfTickets) {
        this.eventBooking = new EventBooking(eventName, attendeeName, attendeeAddress, (long) numberOfTickets);
        return this.eventBooking;
    }

    @Override
    public EventBooking getEventBooking() {
        return eventBooking;
    }
}
