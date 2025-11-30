package pages;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;

public class UserApiPage {
    private ValidatableResponse response;

    @Test(description = "Negative case - Search user dengan ID INVALID-ID harus return error 404")
    @Epic("Web interface")
    @Feature("Search User API")
    @Story("Negative Search Case")
    @Severity(CRITICAL)
    public void NegativeSearchTest() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";

        Response response =
                given().when()
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("app-id", "63a804408eb0cb069b57e43a")
                        .get("/users/INVALID-ID")
                        .then()
                        .log()
                        .all()
                        .extract()
                        .response();

        step("Verifikasi Status code 404 (Not Found)");
        Assert.assertEquals(response.statusCode(), 404);

        step("Verifikasi response body tidak kosong (system tetap berjalan)");
        String responseBody = response.asPrettyString();
        Assert.assertTrue(responseBody != null && !responseBody.isEmpty(),
                "Response Body kosong, seharusnya tetep ada meskipun error!!");

        attachResponse(responseBody);

        System.out.println("Sistem tetap berjalan, return 404 sesuai ekspektasi");

    }

    @Step
    public void step(String message){
        //Agar Step muncul di Allure Report
    }

    @Attachment (value = "API Response", type = "application/json")
    public String attachResponse(String response){
        return response;
    }

    @Test
    public void GetListUsers() {

        File jsonSchema = new File("src/test/resources/jsonSchema/getListUsersSchema.json");

      response = given().when()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a")
                .get("https://dummyapi.io/data/v1/user?limit=10")
                .then().log().all()
                .assertThat().statusCode(200)
//                .assertThat().body("per_page", Matchers.equalTo(6))
//                .assertThat().body("page", Matchers.equalTo(2))
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Test
    public void testPostCreateUser(){
        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@gmail.com";

        String valueName = "John";
        String valueLastName = "Doe";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("firstName", valueName);
        bodyObj.put("lastName", valueLastName);
        bodyObj.put("email", uniqueEmail);

        response =  given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a")
                .body(bodyObj.toString())
                .when()
                .post("https://dummyapi.io/data/v1/user/create")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("firstName", Matchers.equalTo(valueName));

    }

    @Test
    public void testPutUser(){
        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@gmail.com";

        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        //Data to update
        // Pastikan ini userId valid dari hasil GET /user
        String userId = "692adb19ac7daa6bd3c11a52";
        String newName = "Doe";
        //Test put user_id 2 -> update first name
        //First, get the atribute of user id 2
        String fname = given().when().get("/user/" +userId).getBody().jsonPath().get("data.firstName");
        String lname = given().when().get("/user/" +userId).getBody().jsonPath().get("data.lastName");
        String email = given().when().get("/user/" +userId).getBody().jsonPath().get("data.email");
        System.out.println("name before = "+fname);

        //change the first name to "KISANAK"
        //Create body request with HashMap and convert it to json

        HashMap<String, Object> bodyMap =  new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("firstName", newName);
        bodyMap.put("lastName", lname);
        bodyMap.put("email", uniqueEmail);
        JSONObject jsonObject = new JSONObject(bodyMap);

        response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a")
                .body(jsonObject.toString())
                .put("/user/" +userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("firstName", Matchers.equalTo(newName));

    }

    @Test
    public void testPatchUser(){
        int rand = new Random().nextInt(99999);
        String uniqueEmail = "John" + rand + "@gmail.com";

        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        //Data to update
//        int userId = 3;
        String userId = "692adb19ac7daa6bd3c11a52";
        String newName = "DioPatch";

        String fname = given().when().get("/user/" +userId).getBody().jsonPath().get("data.firstName");
        System.out.println("name before = "+fname);


        HashMap<String, Object> bodyMap =  new HashMap<>();
        bodyMap.put("firstName", newName);
        bodyMap.put("email", uniqueEmail);

        JSONObject jsonObject = new JSONObject(bodyMap);

        response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a")
                .body(jsonObject.toString())
                .put("/user/" +userId)
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("firstName", Matchers.equalTo(newName));

    }

    @Test
    public void testDeleteUser(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        //Data to delete
        String userToDelete = "692adb19ac7daa6bd3c11a52";

        response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when().delete("/user/" +userToDelete)
                .then().log().all()
                .assertThat().statusCode(404);

    }

    // Getter biar bisa diakses dari Step Definition
    public ValidatableResponse getResponse() {
        return response;
    }

}
