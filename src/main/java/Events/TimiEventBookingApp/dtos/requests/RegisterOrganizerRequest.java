package Events.TimiEventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterOrganizerRequest {
    private String username;
    private String password;

}
