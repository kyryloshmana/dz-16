package ApiTests;

import PostBooking.Response.ResponseBookingBody;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class ApiChangeBookingTest extends BaseApiTest {

    @Test
    public void putUpdateBookingFirstNameAndAdditional(){
    int id = getNewBooking().getBookingid();

    Response response = putRequest(requestBookingSecond(), id);
    response.then().statusCode(200);
    response.prettyPrint();
    ResponseBookingBody responseBooking = response.as(ResponseBookingBody.class);

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(responseBooking.getFirstname(), apiValuesSecondary.getFirstname());
    softAssert.assertEquals(responseBooking.getLastname(), apiValues.getLastname());
    softAssert.assertEquals(responseBooking.getAdditionalneeds(),  apiValuesSecondary.getAdditionalneeds());
    softAssert.assertEquals(responseBooking.getTotalprice(), apiValues.getTotalprice());
    softAssert.assertTrue(apiValues.isDeposidpaid());
    softAssert.assertEquals(responseBooking.getBookingdates().getCheckin(),  apiValues.getCheckin());
    softAssert.assertEquals(responseBooking.getBookingdates().getCheckout(), apiValues.getCheckout());
    softAssert.assertAll();
    deleteRequest(id);
    }

    @Test
    public void patchUpdateBookingPrice() {
       int id = getNewBooking().getBookingid();
       Response response = patchRequest(requestBookingThird(), id);
       response.then().statusCode(200);
       response.prettyPrint();
       ResponseBookingBody responseBooking = response.as(ResponseBookingBody.class);
       SoftAssert softAssert = new SoftAssert();
       softAssert.assertEquals(responseBooking.getFirstname(), apiValues.getFirstname());
       softAssert.assertEquals(responseBooking.getLastname(), apiValues.getLastname());
       softAssert.assertEquals(responseBooking.getAdditionalneeds(), apiValues.getAdditionalneeds());
       softAssert.assertEquals(responseBooking.getTotalprice(), apiValuesSecondary.getTotalprice());
       softAssert.assertTrue(apiValues.isDeposidpaid());
       softAssert.assertEquals(responseBooking.getBookingdates().getCheckin(),  apiValues.getCheckin());
       softAssert.assertEquals(responseBooking.getBookingdates().getCheckout(), apiValues.getCheckout());
       softAssert.assertAll();
       deleteRequest(id);
    }
}
