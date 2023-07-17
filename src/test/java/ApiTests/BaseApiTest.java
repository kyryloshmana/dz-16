package ApiTests;

import ApiSteps.*;
import PostBooking.Request.PatchRequest.RequestBody;
import PostBooking.Request.RequestBookingBody;
import PostBooking.Response.ResponseBooking;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {

    static ApiValues apiValues = ApiValues.MainPerson;
    static ApiValues apiValuesSecondary = ApiValues.SecondaryPerson;

    @BeforeMethod
    public void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    }

    public static ResponseBooking getNewBooking(){
        Response response = postRequest(requestBookingFirst());
        response.prettyPrint();
        ResponseBooking responseBooking = response.as(ResponseBooking.class);
        return responseBooking;
    }

    public static RequestBookingBody requestBookingFirst(){
        return new ApiSteps().requestBooking(
                apiValues.getCheckin(),
                apiValues.getCheckout(),
                apiValues.getFirstname(),
                apiValues.getLastname(),
                apiValues.getTotalprice(),
                apiValues.isDeposidpaid(),
                apiValues.getAdditionalneeds());
    }

    public static RequestBookingBody requestBookingSecond(){
        return new ApiSteps().requestBooking(
                apiValues.getCheckin(),
                apiValues.getCheckout(),
                apiValuesSecondary.getFirstname(),
                apiValues.getLastname(),
                apiValues.getTotalprice(),
                apiValues.isDeposidpaid(),
                apiValuesSecondary.getAdditionalneeds());
    }

    public static RequestBody requestBookingThird(){
        return new ApiSteps().requestBooking(
                apiValuesSecondary.getTotalprice());
    }

    public static Response postRequest(RequestBookingBody requestBookingBody) {
        return RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBookingBody)
                .post("/booking");
    }

    public static Response getRequest(){
        return RestAssured.given().log().all()
                .get("/booking");
    }

    public static Response getRequest(int id){
        return RestAssured.given().log().all()
                .get("/booking" + id);
    }

    public static Response putRequest(RequestBookingBody requestBookingBody, int id){
        return RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")
                .body(requestBookingBody)
                .put("/booking/" + id);
    }

    public static Response patchRequest(RequestBody requestBody, int id){
        return RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")
                .body(requestBody)
                .patch("/booking/" + id);
    }

    public static Response deleteRequest(int id){
        return RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .auth().basic("Admin", "password123")

                //.body(requestBooking)
                .delete("/booking/" + id);
    }


}
