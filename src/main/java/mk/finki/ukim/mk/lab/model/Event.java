package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double popularityScore;

    @ManyToOne
    private Location location;

    public Event(String name, String description, double popularityScore, Location location) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }


}
