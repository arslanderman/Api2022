package get_requests;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14ObjectMapper extends JasonPlaceHolderBaseUrl {
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
    public  void get01ObjectMapper(){
        //set the url
        spec.pathParams("f","todos","s",198);
        // set the expected data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
       String expectedData = jsonPlaceHolderTestData.
               expectedDataInString(10,"quis eius est sint explicabo",true);


       Map<String,Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);
        System.out.println("expected data map: "+expectedDataMap);

        //send the get request and get the response

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

        //do assertion
       Map<String,Object> actualDataMap = JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actual data map "+actualDataMap);


        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));


    }
    @Test
    public void get02ObjectMapper(){
        //set the uerl
        spec.pathParams("f","todos","s",198);
        // set the expected data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        String expectedData = jsonPlaceHolderTestData.
                expectedDataInString(10,"quis eius est sint explicabo",true);

     JsonPlaceHolderPojo expectedDataPojo =  JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);
        System.out.println(expectedDataPojo);
     // send the request and get the response

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.prettyPrint();

        //do assertion

       JsonPlaceHolderPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());
    }

}
