package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.BookTicketRequest;
import Events.TimiEventBookingApp.dtos.responses.BookTicketResponse;

public interface TicketService{

    BookTicketResponse bookTicket(BookTicketRequest bookTicketRequest);


}
