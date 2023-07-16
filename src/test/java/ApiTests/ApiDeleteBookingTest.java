package ApiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDeleteBookingTest extends  BaseApiTest{

    @Test
    public void deleteBookingTest (){
        int id = getNewBooking().getBookingid();
        deleteRequest(id);
        Assert.assertEquals(404, getRequest(id).statusCode());
        Assert.assertEquals("Not Found", getRequest(id).getBody().asString());

    }
}
