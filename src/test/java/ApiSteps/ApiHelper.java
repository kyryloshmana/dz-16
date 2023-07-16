package ApiSteps;

import PostBooking.Request.RequestBookingDates;


public class ApiHelper {
   public static RequestBookingDates getCheckInOutData(String checkIn, String checkOut){
       return RequestBookingDates.builder()
               .checkin(checkIn)
               .checkout(checkOut)
               .build();
    }


}
