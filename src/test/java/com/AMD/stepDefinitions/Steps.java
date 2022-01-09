package com.AMD.stepDefinitions;

import com.AMD.utilities.APIUtility;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Steps {
    protected RequestSpecification requestSpecification;
    protected Response response;
    protected String token;

    @Given("authorization token is provided for user")
    public void authorization_token_is_provided_for_user() {
        token = APIUtility.getToken();
        System.out.println(token);
    }
    @When("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        requestSpecification = given().contentType(string)
                                      .header("Authorization","Bearer "+token);
    }
    @When("user sends POST request to {string} with following information:")
    public void userSendsPOSTRequestToWithFollowingInformation(String path, List<Map<String, Object>> contacts) {
        for (Map<String, Object> contact : contacts) {
            Gson gson = new Gson();
            Type gsonType = new TypeToken<HashMap>(){}.getType();
            System.out.println(gsonType);
            String gsonString = gson.toJson(contact,gsonType);
            System.out.println(gsonString);
            response = requestSpecification
                    .body(gsonString)
                    .when()
                    .post(path).prettyPeek();
        }
    }
    @When("user creates a body from {string} file")
    public void user_creates_a_body_from_file (String file) {
        File jsonDataInFile = new File("src/test/resources/testData/"+file+".json");
        requestSpecification = requestSpecification.body(jsonDataInFile);
    }
    @When("user sends POST request to {string}")
    public void userSendsPOSTRequestTo(String path) {
            response = requestSpecification
                    .when()
                    .post(path).prettyPeek();
    }
    @Then("user verifies that response status code is {int}")
    public void user_verifies_that_response_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());
    }
}
