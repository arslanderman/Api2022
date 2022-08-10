package get_requests;

import base_urls.HerOkuAppBaseUrl;
import get_requests.pojos.BookingDatesPojo;
import get_requests.pojos.BookingPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get01Pojo(){

        // set the uel
        spec.pathParams("f","booking","s",55);
        // set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2013-02-23","2014-10-23");
        BookingPojo expectedData = new BookingPojo("Sally","Brown",111,
                true,bookingDatesPojo,"Breakfast");

        System.out.println(expectedData);

        //send the get request and get the response

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

        //do assertion

      BookingPojo actualData =  response.as(BookingPojo.class);

      assertEquals(expectedData.getFirstname(),actualData.getFirstname());
      assertEquals(expectedData.getLastname(),actualData.getLastname());
      assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
      assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
      assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
      assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
      assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
      assertEquals(200,response.getStatusCode());

    }
}
