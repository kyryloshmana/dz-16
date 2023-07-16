package ApiSteps;

import ApiTests.BaseApiTest;
import PostBooking.Request.PatchRequest.RequestBody;
import PostBooking.Request.RequestBookingBody;

public class ApiSteps extends BaseApiTest{
    public RequestBookingBody requestBooking(String checkIn, String checkOut, String firstName,
                                             String lastName, int totalPrice, boolean depositPaid,
                                             String additionalNeeds){
        return   RequestBookingBody.builder()
                .firstname(firstName)
                .lastname(lastName)
                .totalprice(totalPrice)
                .depositpaid(depositPaid)
                .bookingdates(ApiHelper.getCheckInOutData(checkIn, checkOut))
                .additionalneeds(additionalNeeds)
                .build();

    }

    public RequestBody requestBooking(int totalPrice){
        return   RequestBody.builder()
                .totalprice(totalPrice)
                .build();

    }

}
