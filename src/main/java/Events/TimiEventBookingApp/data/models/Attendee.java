package Events.TimiEventBookingApp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "attendees")
@Setter
@Getter
public class Attendee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;

}
