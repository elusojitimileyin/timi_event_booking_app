package Events.TimiEventBookingApp.data.repositories;

import Events.TimiEventBookingApp.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
