package ApiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDeleteBookingTest extends  BaseApiTest{

    @Test
    public void deleteBookingTest (){
        int id = getNewBooking().getBookingid();
        Response response = deleteRequest(id);
        response.then().statusCode(201);
        Assert.assertEquals(404, getRequest(id).statusCode());
        Assert.assertEquals("Not Found", getRequest(id).getBody().asString());

    }
}
