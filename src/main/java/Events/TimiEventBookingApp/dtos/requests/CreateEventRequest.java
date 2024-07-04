package Events.TimiEventBookingApp.dtos.requests;

import Events.TimiEventBookingApp.data.constants.EventCategory;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateEventRequest {
    private Long organizerId;
    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private String eventDate;
    private double eventPrice;
    private EventCategory eventCategory;


}
