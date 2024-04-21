package crudOperaion;

import static io.restassured.RestAssured.DEFAULT_URL_ENCODING_ENABLED;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetMethod {

	static Response response;

	@Test
	public void getMethod() {

		response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(response.statusCode());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	// import static io.restassured.RestAssured.*; import this to use given and
	// other function directly\
	@Test
	public void test_2() {
		response = given().get("https://reqres.in/api/users?page=2");
		response.then().statusCode(200);

		// or
		response.then().assertThat().statusCode(200);
	}

	@Test
	public void test_3() {
		baseURI = "https://reqres.in/api/";

		response = given().get("users?page=2");
		response.then().statusCode(200).body("data[1].id", equalTo(8));
		System.out.println(response.getBody().jsonPath().getString("data.id"));
		response.then().body("data.id", hasItems(11, 12));
		response.then().log().body(DEFAULT_URL_ENCODING_ENABLED);

	}

	@Test
	public void test_Post() {

		baseURI = "https://reqres.in/api/";

		Map<String, Object> map = new HashMap<>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		System.out.println(map);

		JSONObject reqObject = new JSONObject(map);
		System.out.println(reqObject);

		response = given().body(reqObject.toJSONString()).when().post("/users");
		response.then().statusCode(201);
		System.out.println(response.then().extract().body().asString());
	}
	@Test
	public void test_header() {
		baseURI = "https://reqres.in/api/";
		Map<String, Object> map = new HashMap<>();
		JSONObject reqObject = new JSONObject(map);
		reqObject.put("name", "morpheus");
		reqObject.put("job", "leader");
		
		response = given()
				.header("Content-Type","application/json")   //we can use this or
				.contentType(ContentType.JSON)               //this and for accepting use below method
				.accept(ContentType.JSON)
				.body(reqObject.toJSONString()).when().post("/users");
		response.then().statusCode(201);
		System.out.println(response.then().extract().body().asString());
	}

}
