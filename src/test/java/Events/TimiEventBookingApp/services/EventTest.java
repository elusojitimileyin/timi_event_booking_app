package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.AddTicketToEventRequest;
import Events.TimiEventBookingApp.dtos.requests.CreateEventRequest;
import Events.TimiEventBookingApp.dtos.responses.AddTicketToEventResponse;
import Events.TimiEventBookingApp.dtos.responses.CreateEventResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EventTest {

    @Autowired
    private  EventService eventService;
    @Autowired
    private TicketService ticketService;
    @Test
    void testOrganizerCanCreateEvent(){
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setOrganizerId(1L);
        createEventRequest.setEventPrice(100.0);
        createEventRequest.setEventLocation("Test Address");
        createEventRequest.setEventDate("2022-01-31T00:00:00");
        createEventRequest.setEventDescription("Test Description");

        CreateEventResponse createEventResponse = eventService.createEvent(createEventRequest);

        assertNotNull(createEventResponse);
        assertTrue(createEventResponse.getMessage().contains("Event created successfully"));
    }

    @Test
    void testThatCanAddTicketToEvent(){


        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setEventId(100L);
        addTicketToEventRequest.setTicketId(1L);
        addTicketToEventRequest.setQuantity(10);


        AddTicketToEventResponse addTicketToEventResponse =
                eventService.addTicketToEvent(addTicketToEventRequest);

        assertNotNull(addTicketToEventResponse);
        assertTrue(addTicketToEventResponse.getMessage().contains("Ticket added to event successfully"));


    }

}
