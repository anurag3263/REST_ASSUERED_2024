package crudOperaion;

import static io.restassured.RestAssured.DEFAULT_URL_ENCODING_ENABLED;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqSpec_ResSpec {
	static Response response;
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;

	@Test
	public void test_3() {
		baseURI = "https://reqres.in/api/";

		reqSpec = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON);
		response = reqSpec.when().get("users?page=2");
		int status = response.statusCode();
		response = response.then().extract().response();
		assertEquals(status, 200);
		System.out.println(response.getBody().jsonPath().getString("data.id"));
		response.then().body("data.id", hasItems(11, 12));
		response.then().log().body(DEFAULT_URL_ENCODING_ENABLED);

		resSpec = resSpec.expect();
		resSpec.statusCode(200);
		resSpec.contentType(ContentType.JSON);
		resSpec.time(Matchers.lessThan(5000L));

	}
}
