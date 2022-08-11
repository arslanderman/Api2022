package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Get16 extends DummyRestApiBaseUrl {

    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    /*
    given
     https://dummy.restapiexample.com/api/v1/employees
     when
     user sends get requestr to the url
     Then
     statuscode is 200
     And
     there are 24 employeees
     And
     Tiger Nixon" and "Garrett Winters" are among the employees
     And
     The greatest age is 66
     And
     The name of the lowest age is "Tatyana Fitzpatrick"
     And
     Total salary of all employees is 6,644,770
     */
    // set the url
    @Test
    public void get01(){
        spec.pathParam("f","employees");
        //set the expected data
        // send the get request and get the response

        Response response = given().spec(spec).when().get("/{f}");
        response.prettyPrint();

        //do assertion
        response.then().assertThat().statusCode(200).body("data.id",hasSize(24),
                "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
    }
}
