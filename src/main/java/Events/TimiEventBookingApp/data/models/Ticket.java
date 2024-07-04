package Events.TimiEventBookingApp.data.models;

import Events.TimiEventBookingApp.data.constants.TicketCategory;
import Events.TimiEventBookingApp.data.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Table(name = "tickets")
@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;
    private String ticketNumber;
    @Enumerated(EnumType.STRING)
    private TicketCategory ticketCategory;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
