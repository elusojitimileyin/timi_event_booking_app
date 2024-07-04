package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.AddTicketToEventRequest;
import Events.TimiEventBookingApp.dtos.requests.CreateEventRequest;
import Events.TimiEventBookingApp.dtos.responses.AddTicketToEventResponse;
import Events.TimiEventBookingApp.dtos.responses.CreateEventResponse;

public interface EventService {

    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    AddTicketToEventResponse addTicketToEvent(AddTicketToEventRequest addTicketToEventRequest);
}
