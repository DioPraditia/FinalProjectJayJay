package com.dio.stepdef.api;

import com.dio.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class HooksAPI extends BaseTest {
    @Before("@api")
    public void setupAPI() {
        // Set base URL global sebelum setiap scenario dengan tag @api
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        System.out.println("=== Starting API Scenario ===");
    }

    @After("@api")
    public void tearDownAPI() {
        System.out.println("=== Finished API Scenario ===");
    }
}
