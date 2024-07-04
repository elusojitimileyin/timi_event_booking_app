package Events.TimiEventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddTicketToEventRequest {
    private Long eventId;
    private Long ticketId;
    private int quantity;
}
