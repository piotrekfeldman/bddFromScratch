Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Check if the Place is succesfully added
 Given Add Place PayLoad with "<name>" "<language>" "<address>"
 When user calls "AddPlaceApi" with "post" http request
 Then the API call got success with status code 200
 And "status" in response body is "OK"
 And "scope" in response body is "APP"
 And verify place_Id created maps to "<name>" using "getAddPlaceAPI"


   Examples:
    |name   |language    | address    |
  #  |mARTA   |polski      | psie pole  |
    |Klosz   |francja     | pilczyce  |

@DeletePlace @Regression
Scenario: Verify if DeletePlace functionality is working
Given DeletePlace Payload
When user calls "deleteAddPlaceAPI" with "post" http request
Then the API call got success with status code 200
And "status" in response body is "OK"