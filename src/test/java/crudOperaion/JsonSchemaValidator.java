package crudOperaion;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;;;

public class JsonSchemaValidator {
	
	static Response response;
	
	@Test
	public void test_schemaValidator() {
		baseURI="https://reqres.in/api/";
		
	response =	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().get("users?page=2");
		response.then().statusCode(200);
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
		
		// add the JSON file in target/class folder and the pass the file name in argument to validate
	}

}
