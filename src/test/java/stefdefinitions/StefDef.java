package stefdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class StefDef {
    @Given("user prepares a post request <{string}>")
    public void user_prepares_a_post_request(String baseUrl) {
        RestAssured.baseURI=baseUrl;
    }
    Response response;
    @When("user performs post request <{string}>")
    public void user_performs_post_request(String endPoint) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("external_id", "SF_TEST001");
        requestParams1.put("name", "San Francisco Test Station");
        requestParams1.put("latitude", 37.76);
        requestParams1.put("longitude", -122.43);
        requestParams1.put("altitude", 150);
        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("external_id", "DEMO_TEST002");
        requestParams2.put("name", "Team Demo Test Station 002");
        requestParams2.put("latitude",  44.44);
        requestParams2.put("longitude",  -122.44);
        requestParams2.put("altitude", 111);
        request.body(requestParams1.toString()).body(requestParams2.toString());
         response = request.post(endPoint);
    }

    @Then("user validates the status code {int} and response")
    public void user_validates_the_status_code_and_response(Integer statusCode) {
        int StatusCode = response.getStatusCode();
        System.out.println("Status code : " + StatusCode);
        System.out.println("Response body: " + response.body().asString()); //Get Response Body


        Assert.assertEquals(response.jsonPath().getInt("cod"),401);
        Assert.assertEquals(response.jsonPath().getString("message"),"Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.");

    }
    @When("user performs post request <{string}> with appid <{string}>")
    public void user_performs_post_request_with_appid(String endpoint, String appid) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams1 = new JSONObject();
        requestParams1.put("external_id", "SF_TEST001");
        requestParams1.put("name", "San Francisco Test Station");
        requestParams1.put("latitude", 37.76);
        requestParams1.put("longitude", -122.43);
        requestParams1.put("altitude", 150);
        JSONObject requestParams2 = new JSONObject();
        requestParams2.put("external_id", "DEMO_TEST002");
        requestParams2.put("name", "Team Demo Test Station 002");
        requestParams2.put("latitude",  44.44);
        requestParams2.put("longitude",  -122.44);
        requestParams2.put("altitude", 111);
        request.body(requestParams1.toString()).body(requestParams2.toString());

        Response response = request.queryParam("appid",appid).post(endpoint);

    }

    @Then("user validates the status code {int}")
    public void user_validates_the_status_code(Integer statuscode) {
        int StatusCode = response.getStatusCode();
        System.out.println("Status code : " + StatusCode);
        System.out.println("Response body: " + response.body().asString()); //Get Response Body
        Assert.assertEquals(response.jsonPath().getInt("cod"),201);

    }
    @When("user performs get request <{string}> with appid <{string}>")
    public void user_performs_get_request_with_appid(String endPoint, String appid) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        Response response = request.queryParam("appid",appid).get(endPoint);
        int StatusCode = response.getStatusCode();
        System.out.println("Status code : " + StatusCode);
        System.out.println("Response body: " + response.body().asString()); //Get Response Body

        Assert.assertEquals(StatusCode,200);


    }

    @Then("user validates the status code {int} and response given")
    public void user_validates_the_status_code_and_response_given(Integer int1) {
        int StatusCode = response.getStatusCode();
        System.out.println("Status code : " + StatusCode);
        System.out.println("Response body: " + response.body().asString()); //Get Response Body
        Assert.assertEquals(response.jsonPath().getInt("cod"), 200);
    }
    }
