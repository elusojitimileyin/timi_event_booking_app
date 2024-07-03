package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.dtos.requests.RegisterOrganizerRequest;
import Events.TimiEventBookingApp.dtos.responses.RegisterOrganizerResponse;

public interface OrganizerService {
    RegisterOrganizerResponse register(RegisterOrganizerRequest registerOrganizerRequest);



}
