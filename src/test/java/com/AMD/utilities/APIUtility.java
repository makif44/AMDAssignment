package com.AMD.utilities;

import io.restassured.response.Response;

import java.util.Base64;

import static io.restassured.RestAssured.given;

public class APIUtility {

    static {
        System.out.println(ConfigurationReader.get("routee.api."+ConfigurationReader.get("environment")));
    }
    /**
     * Method that generates access token by using enums
     *
     * @return bearer token
     */
    public static String getToken() {
        String applicationId = null, applicationSecret = null, base64= null;
        applicationId = ConfigurationReader.get("applicationId");
        applicationSecret = ConfigurationReader.get("applicationSecret");
        String originalInput = applicationId+":"+applicationSecret;
        base64= Base64.getEncoder().encodeToString(originalInput.getBytes());
        String authorizationString = "Basic "+ base64;
        Response response = given()
                .header("Authorization", authorizationString)
                .header("Content-type", "application/x-www-form-urlencoded")
                .queryParam("grant_type", "client_credentials" )
                .when()
                .post("https://auth.routee.net/oauth/token");
        response.then().statusCode(200);
        return response.path("access_token");
    }
}
