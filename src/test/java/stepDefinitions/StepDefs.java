package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefs extends Utils{
	static RequestSpecification req;
	static Response res;
	
	TestDataBuild tdb=new TestDataBuild();

	@Given("AddPlace Payload")
	public void add_place_payload() throws IOException {

		
		req = given().spec(reqSpecificationFunction()).log().all().body(tdb.addPlaceTestData());

	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String string, String string2) {

		res = req.when().post(ApiResources.valueOf(string).getResource());

	}

	@Then("The Api call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer int1) {

		res.then().spec(resSpecificationFunction()).extract().response();
		assertEquals(res.getStatusCode(), 200);

	}

	@Then("{string} in response is {string}")
	public void status_code_in_response_is(String string, String string2) {
		String respString = res.asString();
		System.out.println(respString);
		JsonPath jp = new JsonPath(respString);
		String key = jp.get(string);
		assertEquals(key, string2);
	}

}
