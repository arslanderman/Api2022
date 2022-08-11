package exercise10Aug;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Post03Pojo extends JasonPlaceHolderBaseUrl {

     /*
    Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    //set the url
    @Test
    public void post03(){
        // set the url
        spec.pathParam("first","todos");
        //set the expected data
        Pojo03Class expobj = new Pojo03Class(55,"Tidy your room",false);
        System.out.println("expected data "+expobj);
        //send the post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expobj).when().post("/{first}");
        response.prettyPrint();

        Pojo03Class actualData =response.as(Pojo03Class.class);
        System.out.println("actual data "+actualData);

        //do assertion

        assertEquals(expobj.getUserId(),actualData.getUserId());
        assertEquals(expobj.getTitle(),actualData.getTitle());
        assertEquals(expobj.getCompleted(),actualData.getCompleted());
        assertEquals(201,response.getStatusCode());





    }
}
