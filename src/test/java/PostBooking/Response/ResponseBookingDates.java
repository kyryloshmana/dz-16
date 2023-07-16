package PostBooking.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBookingDates {
    private String checkin;
    private String checkout;
}
