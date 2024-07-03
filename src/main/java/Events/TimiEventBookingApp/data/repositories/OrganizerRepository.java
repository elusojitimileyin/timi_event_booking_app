package Events.TimiEventBookingApp.data.repositories;

import Events.TimiEventBookingApp.data.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
