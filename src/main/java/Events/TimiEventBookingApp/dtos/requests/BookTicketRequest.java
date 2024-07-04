package Events.TimiEventBookingApp.dtos.requests;

import Events.TimiEventBookingApp.data.constants.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketRequest {
    private Long ticketId;
    private String guestName;
    private TicketStatus ticketStatus;
    private Long quantity;


}
