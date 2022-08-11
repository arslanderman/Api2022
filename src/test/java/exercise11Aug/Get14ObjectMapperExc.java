package exercise11Aug;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get14ObjectMapperExc extends JasonPlaceHolderBaseUrl {


    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get01ObjectManner(){
        // set the url
        spec.pathParams("f","todos","s",198);
        // set the expected data



        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        String expectedData = jsonPlaceHolderTestData.
                expectedDataInString(10,"quis eius est sint explicabo",true);

      Map<String,Object> expectedDataMap =  JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        System.out.println(expectedDataMap);

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

        //do assertion
        Map<String,Object> actualDataMap = JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println(actualDataMap);




    }

}
