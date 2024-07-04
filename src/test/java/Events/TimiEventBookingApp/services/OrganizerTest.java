package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.CreateEventRequest;
import Events.TimiEventBookingApp.dtos.requests.RegisterOrganizerRequest;
import Events.TimiEventBookingApp.dtos.responses.CreateEventResponse;
import Events.TimiEventBookingApp.dtos.responses.RegisterOrganizerResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
//@Sql(scripts= {"/db/data.sql"})
//@Slf4j
public class OrganizerTest {

    @Autowired
    private OrganizerService organizerService;
    @Test
    void testOrganizerCanRegisterSuccessfully() {
        RegisterOrganizerRequest  registerOrganizerRequest= new RegisterOrganizerRequest();
        registerOrganizerRequest.setUsername("req@test");
        registerOrganizerRequest.setPassword("password");
        RegisterOrganizerResponse registerOrganizerResponse =
                organizerService.register(registerOrganizerRequest);
        assertNotNull(registerOrganizerResponse);
        assertTrue(registerOrganizerResponse.getMessage().contains("successfully"));
    }




}
