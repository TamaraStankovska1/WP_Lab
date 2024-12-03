package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


    @Query("SELECT e FROM Event e " +
            "WHERE (:name IS NULL OR lower(cast(e.name as string)) " +
            "LIKE LOWER(CONCAT('%', cast(:name as string), '%'))) " +
            "AND (:popularityScore IS NULL OR e.popularityScore >= :popularityScore) " +
            "AND (:locationId IS NULL OR e.location.id = :locationId)")
    List<Event> filterEvents(String name, Double popularityScore, Long locationId);


//    List<Event> findAllByNameLikeAndPopularityScoreGreaterThanEqualAndLocationId(String name, Double popularityScore, Long locationId);
//
//    List<Event> findAllByLocation_id(Long location_id);
////    @Query("SELECT e FROM Event e WHERE e.name LIKE %:keyword%")
////    List<Event> searchEvents(@Param("keyword") String keyword);
//
//    List<Event> findAllByNameLike(String name);
//
//    List<Event> findAllByPopularityScoreGreaterThanEqual(Double popularityScore);
//
//    List<Event> findAllByNameLikeAndPopularityScoreGreaterThanEqual(String name, Double popularityScore);
//
//    List<Event> findAllByNameLikeAndLocationId(String name, Long locationId);
//
//    List<Event> findAllByPopularityScoreGreaterThanEqualAndLocationId(Double  popularityScore, Long locationId);

}
