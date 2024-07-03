package Events.TimiEventBookingApp.data.models;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "discount")
@Setter
@Getter
public class Discount {
    private Long id;

}
