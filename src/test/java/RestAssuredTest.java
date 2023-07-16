import GetBookings.Response.ResponseBody;

import PostBooking.Request.PatchRequest.RequestBody;
import PostBooking.Request.RequestBookingBody;
import PostBooking.Request.RequestBookingDates;
import PostBooking.Response.ResponseBooking;
import PostBooking.Response.ResponseBookingBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RestAssuredTest {

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    public void getBookingId(){
        Response response = RestAssured.given()
                .get("/booking");
        response.prettyPrint();
        ResponseBody[] responseBody = response.as(ResponseBody[].class);
    }

    @Test
    public void postBooking () {
       // LocalDate localDateCheckin = LocalDate.parse("2018-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       // LocalDate localDateCheckout = LocalDate.parse("2019-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        RequestBookingDates bookingdates = RequestBookingDates.builder()
                .checkin("2018-01-01")
                .checkout("2018-01-02")
                .build();

        RequestBookingBody requestBookingBody = new RequestBookingBody().builder()
                .firstname("Kyrylo")
                .lastname("Shmana")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .additionalneeds("burger")
                .build();
        requestBookingBody.setBookingdates(bookingdates);

        Response response = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBookingBody)
                .post("/booking");
        response.prettyPrint();
        ResponseBooking responseBooking = response.as(ResponseBooking.class);

      }

    @Test
    public void putUpdateBookingFirstNameAndAdditional (){
       // LocalDate localDateCheckin = LocalDate.parse("2018-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
       // LocalDate localDateCheckout = LocalDate.parse("2019-01-02", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        RequestBookingDates bookingdates = RequestBookingDates.builder()
                .checkin("2018-01-01")
                .checkout("2018-01-02")
                .build();

        RequestBookingBody requestBookingBody = new RequestBookingBody().builder()
                .firstname("Kyrylo12")
                .lastname("Shmana")
                .totalprice(111)
                .depositpaid(true)
                .bookingdates(bookingdates)
                .additionalneeds("burger31")
                .build();

        requestBookingBody.setBookingdates(bookingdates);

        Response response = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")
                .body(requestBookingBody)
                .put("/booking/790");
        response.prettyPrint();
        ResponseBookingBody responseBooking = response.as(ResponseBookingBody.class);
    }

    @Test
    public void patchUpdateBookingPrice(){

        RequestBody requestBooking = new RequestBody().builder()
                .totalprice(222)
                .build();

        //requestBooking.setBookingdates(bookingdates);

        Response response = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")
                .body(requestBooking)
                .patch("/booking/4504");
        response.prettyPrint();
        ResponseBookingBody responseBooking = response.as(ResponseBookingBody.class);
    }

    @Test
    public void deleteBooking(){
        Response response = RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")
                //.body(requestBooking)
                .delete("/booking/237");
        response.prettyPrint();
    }
}
