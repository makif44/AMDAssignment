package com.AMD.stepDefinitions;

import com.AMD.utilities.ConfigurationReader;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @Before("@api")
    public void setUpAPI(){
        baseURI = ConfigurationReader.get("routee.api."+ConfigurationReader.get("environment"));
    }

}