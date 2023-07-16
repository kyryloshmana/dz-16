package ApiTests;

import PostBooking.Response.ResponseBooking;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiBookingTest extends BaseApiTest{

    @Test
    public void createBooking (){
        Response response = postRequest(requestBookingFirst());
        response.prettyPrint();
        ResponseBooking responseBooking = response.as(ResponseBooking.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseBooking.getBooking().getFirstname(), apiValues.getFirstname());
        softAssert.assertEquals(responseBooking.getBooking().getLastname(), apiValues.getLastname());
        softAssert.assertEquals(responseBooking.getBooking().getAdditionalneeds(), apiValues.getAdditionalneeds());
        softAssert.assertEquals(responseBooking.getBooking().getTotalprice(), apiValues.getTotalprice());
        softAssert.assertTrue(apiValues.isDeposidpaid());
        softAssert.assertEquals(responseBooking.getBooking().getBookingdates().getCheckin(), apiValues.getCheckin());
        softAssert.assertEquals(responseBooking.getBooking().getBookingdates().getCheckout(), apiValues.getCheckout());
        softAssert.assertAll();
    }
}
