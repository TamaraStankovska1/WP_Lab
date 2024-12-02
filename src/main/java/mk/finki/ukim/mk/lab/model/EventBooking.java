package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EventBooking {
    String eventName;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;
}
