package exercise11Aug;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class PojoGet13Exc extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
    {
    "meta": null,
    "data": {
        "id": 13,
        "name": "Tushar Panicker II",
        "email": "tushar_panicker_ii@green.io",
        "gender": "female",
        "status": "inactive"
    }
}
}
    */
    @Test
    public void get01(){
        //set the url
        spec.pathParams("f","users","s",13);
        // set the expected data
        PojoGet13Data objdata = new PojoGet13Data(13,"Tushar Panicker II",
                "tushar_panicker_ii@green.io","female","inactive");
        PojoGet13Mata objExpected = new PojoGet13Mata(null,objdata);
        System.out.println("expected data: "+objExpected);

        //send the get request and get the response
        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

        //do the assertion
      PojoGet13Actual actualData =  response.as(PojoGet13Actual.class);
        System.out.println("actual data: "+actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(objExpected.getMeta(),actualData.getMeta());
        assertEquals(objExpected.getData().getName(),actualData.getData().getName());
        assertEquals(objExpected.getData().getId(),actualData.getData().getId());
        assertEquals(objExpected.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(objExpected.getData().getGender(),actualData.getData().getGender());
        assertEquals(objExpected.getData().getStatus(),actualData.getData().getStatus());

    }



}
