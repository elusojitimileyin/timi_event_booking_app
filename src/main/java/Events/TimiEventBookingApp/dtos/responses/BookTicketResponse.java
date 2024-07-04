package Events.TimiEventBookingApp.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookTicketResponse {
    @JsonProperty("ticket_id")
    private String id;
    private String message;
}
