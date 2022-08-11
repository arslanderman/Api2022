package post_request;

import base_urls.HerOkuAppBaseUrl;
import pojos.pojos.BookingDatesPojo;
import pojos.pojos.BookingPojo;
import pojos.pojos.BookingResponseBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post04Pojo extends HerOkuAppBaseUrl {
    /*
    Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                    "additionalneeds": "Breakfast with white tea"
                                     }
                                  }
     */
    @Test
    public void post01(){
        //set the url

        spec.pathParam("f","booking");

        //expected data
        //1 inner pojo
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-09-21","2021-12-21");

        //2 outerpojo
        BookingPojo bookingpojo = new BookingPojo("Ali","Can",999,
                true,bookingDatesPojo,"Breakfast with white tea");
        //send the post request and get the response

        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(bookingpojo).when().post("/{f}");
        response.prettyPrint();

        //do assertion
       BookingPojo actualPojo = response.as(BookingPojo.class);
        //System.out.println("actual "+actualPojo);
        /*
        BookingResponseBodyPojo actualPojo = response.as(BookingResponseBodyPojo.class);
         */
        /*
        BookingResponseBody actualPojo = response.as(BookingResponseBody.class);
        System.out.println("actualPojo "+actualPojo);

        assertEquals(bookingpojo.getFirstname(),actualPojo.getBooking().getFirstname());
        assertEquals(bookingpojo.getLastname(),actualPojo.getBooking().getLastname());
        assertEquals(bookingpojo.getTotalprice(),actualPojo.getBooking().getTotalprice());
        assertEquals(bookingpojo.getDepositpaid(),actualPojo.getBooking().getDepositpaid());
        assertEquals(bookingpojo.getBookingdates().getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingpojo.getBookingdates().getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(bookingpojo.getAdditionalneeds(),actualPojo.getBooking().getAdditionalneeds());
       assertEquals(200,response.getStatusCode());

         */



    }

}
