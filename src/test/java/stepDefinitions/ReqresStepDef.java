package stepDefinitions;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.reqresCreateUser;
import resources.ApiResources;
import resources.TestDataBuild;

public class ReqresStepDef {
	RequestSpecification req;
	Response postReq;
	Response thenResponse;
	TestDataBuild tdb=new TestDataBuild();
	@Given("CreateUser payload")
	public void create_user_payload() {
		
		req = given().baseUri("https://reqres.in/").contentType(ContentType.JSON).log().all().body(tdb.reqCreateUser());
	}
	@When("User hits {string} with {string} request")
	public void user_hits_with_request(String string, String string2) {
		
		if(string2.equalsIgnoreCase("Post")) {
		postReq = req.when().post(ApiResources.valueOf(string).getResource());
		}
		else if(string2.equalsIgnoreCase("Get")) {
			postReq = req.when().get(ApiResources.valueOf(string).getResource());
		}
		else if(string2.equalsIgnoreCase("Put")) {
			postReq = req.when().put(ApiResources.valueOf(string).getResource());
		}
	}
	@Then("Api is successful with status code {string}")
	public void api_is_successful_with_status_code(String string) {
		int i=Integer.parseInt(string);  
		thenResponse = postReq.then().extract().response();
		assertEquals(thenResponse.getStatusCode(),i);
		
	}
	@Then("{string} tag in response is {string}")
	public void tag_in_response_is(String string, String string2) {
		String repString=thenResponse.asString();
		System.out.println(repString);
		JsonPath jp=new JsonPath(repString);
		String key = jp.get(string);
		assertEquals(key, string2);
		
	}
	
	@Given("UpdateUser payload")
	public void update_user_payload() {
		req=given().baseUri("https://reqres.in").contentType(ContentType.JSON).log().all().body(tdb.reqUpdateUser());
	}

}
