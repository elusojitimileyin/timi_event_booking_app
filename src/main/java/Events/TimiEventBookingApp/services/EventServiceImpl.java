package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.data.models.Event;
import Events.TimiEventBookingApp.data.models.Organizer;
import Events.TimiEventBookingApp.data.models.Ticket;
import Events.TimiEventBookingApp.data.repositories.EventRepository;
import Events.TimiEventBookingApp.data.repositories.OrganizerRepository;
import Events.TimiEventBookingApp.data.repositories.TicketRepository;
import Events.TimiEventBookingApp.dtos.requests.AddTicketToEventRequest;
import Events.TimiEventBookingApp.dtos.requests.CreateEventRequest;
import Events.TimiEventBookingApp.dtos.responses.AddTicketToEventResponse;
import Events.TimiEventBookingApp.dtos.responses.CreateEventResponse;
import Events.TimiEventBookingApp.exceptions.EventNotFound;
import Events.TimiEventBookingApp.exceptions.OrganizerNotFound;
import Events.TimiEventBookingApp.exceptions.TicketNotFound;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{

    @Autowired
    private final OrganizerRepository organizerRepository;
    @Autowired
    private final EventRepository eventRepository;
    @Autowired
    private final TicketRepository ticketRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        Organizer organizer = organizerRepository.findById(createEventRequest.getOrganizerId())
                .orElseThrow(() -> new OrganizerNotFound("Organizer not found"));
        Event event = modelMapper.map(createEventRequest, Event.class);
        event.setOrganizer(organizer);
        event.setAttendees(new HashSet<>());
        event = eventRepository.save(event);
        var createEventResponse = modelMapper.map(event, CreateEventResponse.class);
        createEventResponse.setMessage("Event created successfully");
        return createEventResponse;
    }

    @Override
    public AddTicketToEventResponse addTicketToEvent(AddTicketToEventRequest addTicketToEventRequest) {
        Ticket ticket = ticketRepository.findById(addTicketToEventRequest.getTicketId())
                .orElseThrow(() -> new TicketNotFound("Ticket not found"));
        Event event = eventRepository.findById(addTicketToEventRequest.getEventId())
                .orElseThrow(() -> new EventNotFound("Event not found"));
        event.getAttendees().add(ticket);

        // Save the updated event
        eventRepository.save(event);

        // Map the ticket to response DTO
        AddTicketToEventResponse addTicketToEventResponse = modelMapper.map(ticket, AddTicketToEventResponse.class);
        addTicketToEventResponse.setMessage("Ticket added to event successfully");

        return addTicketToEventResponse;
    }

}
