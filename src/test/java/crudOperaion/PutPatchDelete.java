package crudOperaion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PutPatchDelete {
	private static final Logger logger = LogManager.getLogger(PutPatchDelete.class); // this log4j2 logger
	
	

	static Response response;

	@Test
	public void test_put() {

		baseURI = "https://reqres.in/api/";

		Map<String, Object> map = new HashMap<>();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		JSONObject reqObject = new JSONObject(map);
		response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(reqObject.toJSONString()).when().put("/users/2");
		response.then().statusCode(200);
		System.out.println(response.then().extract().body().asString());
	}

	@Test
	public void test_patch() {

		baseURI = "https://reqres.in/api/";

		Map<String, Object> map = new HashMap<>();
		map.put("name", "morpheus");
		map.put("job", "zion resident");
		JSONObject reqObject = new JSONObject(map);
		response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(reqObject.toJSONString()).when().patch("/users/2");
		response.then().statusCode(200);
		logger.info("This is patch call " + response.then().extract().statusCode());
		System.out.println(response.then().extract().body().asString());
	}

	@Test
	public void test_delete() {

		baseURI = "https://reqres.in/api/";

		response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().delete("/users/2");
		response.then().statusCode(204);
		System.out.println(response.then().extract().body().asString());
	}

}
