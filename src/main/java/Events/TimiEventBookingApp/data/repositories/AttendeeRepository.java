package Events.TimiEventBookingApp.data.repositories;

import Events.TimiEventBookingApp.data.models.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee,Long> {

}
