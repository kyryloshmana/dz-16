package PostBooking.Request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBookingDates {
    private String checkin;
    private String checkout;
}
