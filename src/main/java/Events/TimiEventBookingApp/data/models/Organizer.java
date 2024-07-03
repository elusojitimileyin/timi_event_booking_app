package Events.TimiEventBookingApp.data.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;



    @Entity
    @Table(name = "organizers")
    @Setter
    @Getter
    public class Organizer {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;
        @Column(unique = true, nullable = false)
        private String username;
        private String password;
        @Setter(AccessLevel.NONE)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime timeCreated;
        @Setter(AccessLevel.NONE)
        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        private LocalDateTime timeUpdated;

        @PrePersist
        private void setTimeCreated() {
            this.timeCreated = now();
        }

        @PreUpdate
        private void setTimeUpdated(){
            this.timeUpdated = now();
        }


    }

