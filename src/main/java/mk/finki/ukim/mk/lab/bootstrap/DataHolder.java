package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<Location> locations= null;



    @PostConstruct
    public void init() {

        locations = new ArrayList<>();
        locations.add(new Location("location1", "Location1Adress", "Location1Capacity", "Location1Description"));
        locations.add(new Location("location2", "Location2Adress", "Location2Capacity", "Location2Description"));
        locations.add(new Location("location3", "Location3Adress", "Location3Capacity", "Location3Description"));
        locations.add(new Location("location4", "Location4Adress", "Location4Capacity", "Location4Description"));
        locations.add(new Location("location5", "Location5Adress", "Location5Capacity", "Location5Description"));

        events = new ArrayList<>();
        events.add(new Event("Event 1", "event 1", 1, locations.get(0)));
        events.add(new Event("Event 2", "event 2", 3, locations.get(1)));
        events.add(new Event("Event 3", "event 3", 10, locations.get(2)));
        events.add(new Event("Event 4", "event 4", 2, locations.get(3)));
        events.add(new Event("Event 5", "event 5", 5, locations.get(4)));
        events.add(new Event("Event 6", "event 6", 1, locations.get(0)));
        events.add(new Event("Event 7", "event 7", 10,locations.get(1) ));
        events.add(new Event("Event 8", "event 8", 5, locations.get(2)));
        events.add(new Event("Event 9", "event 9", 5, locations.get(3)));
        events.add(new Event("Event 10", "event 10", 6, locations.get(4)));

    }
}



