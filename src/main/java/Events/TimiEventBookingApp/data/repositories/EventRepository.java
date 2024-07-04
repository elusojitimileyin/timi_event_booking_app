package Events.TimiEventBookingApp.data.repositories;

import Events.TimiEventBookingApp.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {





}
