package exercise10Aug;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post04PojoTrial extends HerOkuAppBaseUrl {
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
                                        },
                                    "additionalneeds": "Breakfast with white tea"
                                     }
                                  }
     */
    @Test
    public  void post04(){
        // set the url
        spec.pathParam("f","booking");
        // set the expected data
        //inner class
        Pojo04ClassBookingDates bookingDates = new Pojo04ClassBookingDates("2021-09-21","2021-12-21");
        System.out.println(bookingDates);
        //expected data
        Pojo04ClassExpectedData expectedData = new Pojo04ClassExpectedData("Ali","Can",
                999,true,bookingDates,"Breakfast with white tea, Dragon juice");
      // System.out.println("expected data: "+expectedData);


        //send the post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expectedData).when().post("/{f}");
        response.prettyPrint();
        //assertEquals(200,response.getStatusCode());


          // Pojo04ClassResponsePojo actualData = response.as(Pojo04ClassResponsePojo.class);

       // System.out.println("actual data: "+actualData);

        //do assertion
        /*
        assertEquals(expectedData.getFirstname(),actualData.g);
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingdates.getCheckin(),actualData.getBookingDates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBookingDates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

         */




    }
}
