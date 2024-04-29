package crudOperaion;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoAndDto.PutCall;
import utils.GenericUtils;

public class JsonClass {

	JSONObject jsonData = GenericUtils.jsonReader("//src/test/resources//TestData//PutCall.json");

	static Response response;

	@Test
	public void test_put() throws IOException, ParseException {

		baseURI = "https://reqres.in/api/";
		PutCall callDetails = new PutCall();
		callDetails.setName(jsonData.get("name").toString());
		callDetails.setJob(jsonData.get("job").toString());

		ObjectMapper objectMapper = new ObjectMapper();
		String reqJson = null;
		try {
			reqJson = objectMapper.writeValueAsString(callDetails);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("Request Body : " + reqJson);
		response = given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(reqJson).when().put("/users/2");
		response.then().statusCode(200);
		System.out.println(response.then().extract().body().asString());
	}

}
