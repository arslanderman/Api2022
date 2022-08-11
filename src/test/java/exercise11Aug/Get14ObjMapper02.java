package exercise11Aug;

import base_urls.JasonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;
import utils.JsonUtilNew;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get14ObjMapper02 extends JasonPlaceHolderBaseUrl {
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
    public void get01(){
        //set the url

        spec.pathParams("f","todos","s",198);
        //set the expected data
        TestDataForObjectMapper newobj = new TestDataForObjectMapper();


     String expected = newobj.expectedDataInString(10,"quis eius est sint explicabo",true);

        Map<String,Object> expectedMap = JsonUtilNew.convertJsonToJavaObject(expected,HashMap.class);
        System.out.println("exp "+expectedMap);

        //send the gest request and grt the response

        Response response = given().spec(spec).when().get("/{f}/{s}");
        response.then().assertThat().statusCode(200);
        HashMap<String,Object> actualMap = JsonUtilNew.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("act "+actualMap);

        assertEquals(expectedMap.get("userId"),actualMap.get("userId"));
        assertEquals(expectedMap.get("title"),actualMap.get("title"));
        assertEquals(expectedMap.get("completed"),actualMap.get("completed"));
    }

}
