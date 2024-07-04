package Events.TimiEventBookingApp.data.models;

import Events.TimiEventBookingApp.data.constants.EventCategory;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;
import static lombok.AccessLevel.NONE;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String eventName;
    private String eventDescription;
    private String eventLocation;
    private Double eventPrice;

    @OneToOne
    private Organizer organizer;
    @OneToOne
    private Ticket ticket;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "event_attendees",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "attendee_id")
    )
    private Set<Attendee> attendees = new HashSet<>();

    @Enumerated(STRING)
    private EventCategory eventCategory;

    @Setter(NONE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime eventDate;

    @PrePersist
    private void setEventDate() {
        this.eventDate = now();
    }


}
