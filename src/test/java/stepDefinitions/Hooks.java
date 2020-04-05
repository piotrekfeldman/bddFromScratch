package stepDefinitions;


import io.cucumber.java.Before;

import java.io.FileNotFoundException;

public class Hooks {

    @Before("@DeletePlace")
    public void Before() throws FileNotFoundException {

        StepDefinition s = new StepDefinition();

        if (StepDefinition.placeid == null) {
            s.add_Place_PayLoad_with("ppp", "romanian", "zachodnia");
            s.user_calls_with_http_request("AddPlaceApi", "post");
            s.verify_place_Id_created_maps_to_using("ppp", "getAddPlaceAPI");
        }


    }
}