package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByNameLikeAndPopularityScoreGreaterThanEqualAndLocationId(String name, Double popularityScore, Long locationId);

    List<Event> findAllByLocation_Id(Long locationId);

    List<Event> findAllByNameLike(String name);

    List<Event> findAllByPopularityScoreGreaterThanEqual(Double popularityScore);

    List<Event> findAllByNameLikeAndPopularityScoreGreaterThanEqual(String name, Double popularityScore);

    List<Event> findAllByNameLikeAndLocationId(String name, Long locationId);

    List<Event> findAllByPopularityScoreGreaterThanEqualAndLocationId(Double  popularityScore, Long locationId);

}
