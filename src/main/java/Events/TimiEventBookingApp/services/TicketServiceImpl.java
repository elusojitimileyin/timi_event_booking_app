package Events.TimiEventBookingApp.services;


import Events.TimiEventBookingApp.data.models.Attendee;
import Events.TimiEventBookingApp.data.repositories.AttendeeRepository;
import Events.TimiEventBookingApp.dtos.requests.BookTicketRequest;
import Events.TimiEventBookingApp.dtos.responses.BookTicketResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EventService eventService;
    @Autowired
    private AttendeeRepository attendeeRepository;
    @Override
    public BookTicketResponse bookTicket(BookTicketRequest bookTicketRequest) {
        Attendee guest = modelMapper.map(bookTicketRequest, Attendee.class);
        guest= attendeeRepository.save(guest);
        BookTicketResponse response = modelMapper.map(guest, BookTicketResponse.class);
        response.setMessage("ticket booked successfully");
        return response;



    }
}
