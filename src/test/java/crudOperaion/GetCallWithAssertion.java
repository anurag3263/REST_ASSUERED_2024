package crudOperaion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.GenericUtils;

public class GetCallWithAssertion {
	JSONObject jsonData = GenericUtils.jsonReader("//src/test/resources//TestData//NestedData.json");
	JSONObject supportDetails = (JSONObject) jsonData.get("support");
	JSONArray dataJsonArray = (JSONArray) jsonData.get("data");

	private static final Logger logger = LoggerFactory.getLogger(GetCallWithAssertion.class);

	static Response response;

	@Test
	public void test_get() throws IOException, ParseException {

		baseURI = "https://reqres.in/api/";

		response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().get("/users?page=2");
		// response.then().statusCode(200).log().all(); //if you want to log all
		response.then().statusCode(200);
		System.out.println(response.then().extract().body().asString());

		JsonPath jsonPath = new JsonPath(response.asString());
		assertEquals(jsonPath.getString("page"), jsonData.get("page").toString());
		logger.info("page : " + jsonPath.getString("page"));

		System.out.println(jsonPath.getString("support.url") + " : " + supportDetails.get("url"));
		assertEquals(jsonPath.getString("support.url"), supportDetails.get("url"));
		int count = 0;
		for (int i = 0; i < dataJsonArray.size(); i++) {
			JSONObject object = (JSONObject) dataJsonArray.get(i);
			String objectString = (String) object.get("email");
			if (objectString.equalsIgnoreCase(jsonPath.getString("data[0].email"))) {
				break;
			}
			count++;
		}
		JSONObject details = (JSONObject) dataJsonArray.get(count);
		System.out.println(jsonPath.getString("data[0].email") + " : " + details.get("email").toString());
		System.out.println(jsonPath.getString("data.email"));
		response.then().body("data.email", Matchers.hasItems("michael.lawson@reqres.in"));
	}
}