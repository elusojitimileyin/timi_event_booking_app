package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.CreateEventRequest;
import Events.TimiEventBookingApp.dtos.requests.RegisterOrganizerRequest;
import Events.TimiEventBookingApp.dtos.responses.RegisterOrganizerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest

public class OrganizerTest {

    @Autowired
    private OrganizerService OrganizerService;
    @Test
    void testOrganizerCanRegisterSuccessfully() {
        RegisterOrganizerRequest  registerOrganizerRequest= new RegisterOrganizerRequest();
        registerOrganizerRequest.setUsername("reg@test");
        registerOrganizerRequest.setPassword("password");
        RegisterOrganizerResponse registerOrganizerResponse = OrganizerService.register(registerOrganizerRequest);
        assertNotNull(registerOrganizerResponse);
        assertTrue(registerOrganizerResponse.getMessage().contains("successfully"));
    }

    @Test
    void testOrganizerCanCreateEvent(){
        CreateEventRequest createEventRequest = new CreateEventRequest();

    }

}
