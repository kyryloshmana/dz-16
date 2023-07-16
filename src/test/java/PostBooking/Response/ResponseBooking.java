package PostBooking.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBooking {

    private int bookingid;
    private ResponseBookingBody booking;
}
