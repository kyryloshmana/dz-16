package ApiTests;

import GetBookings.Response.ResponseBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiGetBookingTest extends BaseApiTest {

    @Test
    public void getBookingsTest(){
        Response response = getRequest();
        response.then().statusCode(200);
        response.prettyPrint();
        ResponseBody[] responseBody = response.as(ResponseBody[].class);

        for (ResponseBody body: responseBody){
            int value = body.getBookingid();
            Assert.assertTrue(value !=0);
        }
    }
}
