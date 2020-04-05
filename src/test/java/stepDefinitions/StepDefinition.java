package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResourcesEnum;
import resources.TestData;
import resources.Utils;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StepDefinition extends Utils {

   private RequestSpecification reqSpec;
  //  RequestSpecification rq;
  private ResponseSpecification respSpec;
    private Response response;
    static String placeid;

    TestData data=new TestData();
    @Given("Add Place PayLoad with {string} {string} {string}")
    public void add_Place_PayLoad_with(String name, String language, String address)throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given");


        //do ww. dodajemy również funkcje given oraz body tak aby jeszcze bardziej skrócić kod, po czym wrzucamy w zmienną r
        reqSpec=given().spec(RequestSpec()).body(data.Data(name,language,address));

        //tę samą czynność wykonujemy w stoosunku do odpowiedzi (response)
        respSpec=new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
//        throw new io.cucumber.java.PendingException();
    }



    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When");

        APIResourcesEnum apiresource=APIResourcesEnum.valueOf(resource);
        System.out.println(apiresource.getResource());


        if(method.equalsIgnoreCase(method))
            response=reqSpec.when().post(apiresource.getResource());
        else if(method.equalsIgnoreCase(method))
            response= reqSpec.when().get(apiresource.getResource());


        //  throw new io.cucumber.java.PendingException();
    }
    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer expectedCode) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then1");
        assertEquals(200,response.getStatusCode());


        //  throw new io.cucumber.java.PendingException();
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then2");


        assertEquals(getJsonPath(response,key),value);


    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        placeid=getJsonPath(response,"place_id");
        getJsonPath(response,"reference");

        reqSpec=given().spec(RequestSpec()).queryParam("place_id",placeid);
        user_calls_with_http_request(resource,"GET");

        String actualName=getJsonPath(response,"name");
        assertEquals(actualName,expectedName);
     //   throw new io.cucumber.java.PendingException();
    }

    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
        reqSpec=given().spec(RequestSpec()).body(data.deletePlacePayLoad(placeid));
    }


}
