package pojo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class serializeTestSpecBuilder {
private RequestSpecification rq;
private RequestSpecification r;
private  ResponseSpecification ro;
    public static void main(String[] args)

    {
        AddPlace p=new AddPlace();

        p.setAccuracy(50);
        p.setAddress("Lotnicza 147");
        p.setLanguage("French-IN");
        p.setPhone_number("648916216");
        p.setWebsite("onet.pl");
        p.setName("lol");
        List<String> myList=new ArrayList<String>();
        myList.add("cpsds");
        myList.add("dsaa");
        p.setTypes(myList);
        Location l=new Location();
        l.setLat(50.3091283092);
        l.setLng(-32.901821);

        p.setLocation(l);


        //budujemy podstawowe parametry dla requesta (te, które się będą powatarzać w testach)
        RequestSpecification rq=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
        .setContentType(io.restassured.http.ContentType.JSON).build();

        //do ww. dodajemy również funkcje given oraz body tak aby jeszcze bardziej skrócić kod, po czym wrzucamy w zmienną r
        RequestSpecification r=given().spec(rq).body(p);

        //tę samą czynność wykonujemy w stoosunku do odpowiedzi (response)
        ResponseSpecification ro=new ResponseSpecBuilder().expectContentType(io.restassured.http.ContentType.JSON).expectStatusCode(200).build();

      Response rr=  r.when().post("/maps/api/place/add/json").
                then().spec(ro).extract().response();

  /*  RestAssured.baseURI="https://rahulshettyacademy.com";

        Response res=given().queryParam("key","qaclick123").
                body(p).when().post("/maps/api/place/add/json").
                then().statusCode(200).extract().response();*/

       String r1= rr.asString();
        System.out.println(r1);
     //   JsonPath js=ReusableMethods.rawToJson(res);



    }
}
