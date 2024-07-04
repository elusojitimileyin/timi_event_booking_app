package Events.TimiEventBookingApp.dtos.responses;

import Events.TimiEventBookingApp.data.constants.EventCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateEventResponse {
    @JsonProperty("event_id")
    private Long id;
    private EventCategory eventCategory;
    @JsonFormat(pattern = "dd/MMM/yyyy 'at' hh:mm a")
    private LocalDateTime eventDate;
    @JsonFormat(pattern = "dd/MMM/yyyy 'at' hh:mm a")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "dd/MMM/yyyy 'at' hh:mm a")
    private LocalDateTime endDate;
    private String message;
}
