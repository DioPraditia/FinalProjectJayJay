package com.dio.stepdef.api;


import io.restassured.RestAssured;
import org.json.JSONObject;
import pages.UserApiPage;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiCrudSteps {
    UserApiPage userApi = new UserApiPage();
    Response response;

    @Given("User sends GET request to retrieve list users")
    public void GetListUsersWith() {
        userApi.GetListUsers();
    }

    @When("User sends POST request to create user with name {string}, lastName {string}, email {string}")
    public void create_user(String valueName, String valueLastName, String valueEmail) {
         userApi.testPostCreateUser();

        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@test.com";

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", "John");
        reqBody.put("email", uniqueEmail);
        reqBody.put("lastName", "Doe");

        response = RestAssured.given()
                .contentType("application/json")
                .body(reqBody.toString())
                .post("https://dummyapi.io/data/v1/user/create");

        System.out.println("Name: " + valueName);
        System.out.println("lastName: " + valueLastName);
        System.out.println("email: " + valueEmail);

    }
    @Then("Response body should contain {string}")
    public void verify_response_body(String field, String expectedValue) {
        String actualValue = response.jsonPath().getString(field);
        Assert.assertEquals(actualValue, expectedValue,
                "Field value does not match");
    }

    @And("Response field {string} should be {string}")
    public void responseFieldShouldBe(String arg0, String arg1) {
    }

    @When("User sends PUT request to update user with id {string} name {string} and email {string}")
    public void update_user(String id, String valueName, String valueEmail) {
       userApi.testPutUser();

        String userId = "692adb19ac7daa6bd3c11a52";

        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@test.com";

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", valueName);
        reqBody.put("email", uniqueEmail);
        reqBody.put("id", userId);

        response = RestAssured.given()
                .contentType("application/json")
                .body(reqBody.toString())
                .post("/user/");

        System.out.println("Name: " + valueName);
        System.out.println("id: " + userId);
        System.out.println("email: " + valueEmail);
    }

    @When("User sends Patch request to update user with id {string} name {string} and email {string}")
    public void patch_user(String id, String valueName, String valueEmail) {
        userApi.testPatchUser();

        String userId = "692adb19ac7daa6bd3c11a52";

        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@test.com";

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", valueName);
        reqBody.put("email", uniqueEmail);
        reqBody.put("id", userId);

        response = RestAssured.given()
                .contentType("application/json")
                .body(reqBody.toString())
                .post("/user/");

        System.out.println("Name: " + valueName);
        System.out.println("id: " + userId);
        System.out.println("email: " + valueEmail);


    }

    @When("User sends DELETE request to delete user with id {string}")
    public void delete_user(String id) {
         userApi.testDeleteUser();

        String userToDelete = "692adb19ac7daa6bd3c11a52"; //6921c09e5e9849f3a69d46d5

        response = RestAssured
                .given()
                .when()
                .delete("/users/" + userToDelete)
                .then()
                .extract()
                .response();
    }

    @Then("Response status code should be {int}")
    public void verify_status_code(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }


}
