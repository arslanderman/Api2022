package get_requests;

import base_urls.GoRestBaseUrl;
import get_requests.pojos.GoRestDataBodyOuterPojoResponse;
import get_requests.pojos.GoRestDataPojoInnerPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
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
        "name": "Deb Namboothiri DC",
        "email": "dc_deb_namboothiri@barrows.info",
        "gender": "female",
        "status": "inactive"
    }
}
    */
    @Test
    public void get01Pojo(){
        // set the url
        spec.pathParams("f","users","s",3615);
        // set the expected data
        GoRestDataPojoInnerPojo innerPojo = new GoRestDataPojoInnerPojo(3615,"Sarisha Mehrotra",
                "mehrotra_sarisha@crooks.biz","male","inactive");
        GoRestDataBodyOuterPojoResponse expectedData = new GoRestDataBodyOuterPojoResponse(null,innerPojo);

        System.out.println("expected data "+expectedData);

        // send the request and get the response

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();
        GoRestDataBodyOuterPojoResponse actualData = response.as(GoRestDataBodyOuterPojoResponse.class);

        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(200,response.getStatusCode());

    }

}
