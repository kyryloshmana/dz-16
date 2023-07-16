package PostBooking.Response;

import PostBooking.Request.RequestBookingDates;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBookingBody {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private RequestBookingDates bookingdates;
    private String additionalneeds;
}
