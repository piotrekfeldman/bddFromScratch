package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
    public static RequestSpecification rq;

        public RequestSpecification RequestSpec () throws FileNotFoundException {

            RestAssured.baseURI = "https://rahulshettyacademy.com";

            if (rq == null) {
                PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
                rq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                        .addFilter(RequestLoggingFilter.logRequestTo(log)).
                                addFilter(ResponseLoggingFilter.logResponseTo(log)).
                                setContentType(ContentType.JSON).build();

                return rq;
            }
            return rq;
        }


    public String getJsonPath(Response response, String key){
        String respon=response.asString();

        JsonPath js=new JsonPath(respon);
        return js.get(key).toString();
    }
}
