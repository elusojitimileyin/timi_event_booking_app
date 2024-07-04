package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.data.models.Ticket;
import Events.TimiEventBookingApp.dtos.requests.BookTicketRequest;
import Events.TimiEventBookingApp.dtos.responses.BookTicketResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static Events.TimiEventBookingApp.data.constants.TicketStatus.CONFIRMED;

@SpringBootTest
public class TicketTest {
    @Autowired
    private TicketService ticketService;
    @Test
    void testGuestCanBookTicket() {
        BookTicketRequest request = new BookTicketRequest();
        request.setTicketId(request.getTicketId());
        request.setTicketStatus(CONFIRMED);
        request.setQuantity(request.getQuantity());
        request.setGuestName("tush");
        BookTicketResponse response = ticketService.bookTicket(request);
        assert response.getMessage().contains("ticket booked successfully");





    }
}
