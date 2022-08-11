package exercise10Aug;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get12Exercise extends HerOkuAppBaseUrl {
    /*
       Given
            https://restful-booker.herokuapp.com/booking/55
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
  {
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-08-09",
        "checkout": "2022-08-27"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get12(){
        spec.pathParams("f","booking","s",55);
        Pojo12 bookingdates = new Pojo12("2022-08-09","2022-08-27");
        ExpectedPojo12 expectedData = new ExpectedPojo12("Jim","Brown",
                111,true,bookingdates,"Breakfast");
        System.out.println(expectedData);

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

     ExpectedPojo12 actualData =    response.as(ExpectedPojo12.class);
        System.out.println(actualData);

        assertEquals(bookingdates.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(200,response.getStatusCode());

    }
}
