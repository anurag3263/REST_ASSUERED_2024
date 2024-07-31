package crudOperaion;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class WiremockTest {

	private static final String Host = "localhost";
	private static final int Port = 8089;
	private static WireMockServer server = new WireMockServer(Port);
	private static final String END_POINT = "/readfromfile/index";
	static Response response;

	@BeforeClass
	public void initializeServer() {
		System.out.println("Initializing Wiremock Server on port 8089 ....");

		server.start();
		WireMock.configureFor(Host, Port);

		ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		mockResponse.withBodyFile("WiremockTestData/reqUsers2.json");
		WireMock.stubFor(WireMock.get(END_POINT).willReturn(mockResponse));
	}

	@Test
	public void mockTest() {
		String testApi = "http://localhost:" + Port + END_POINT;
		System.out.println("Service to be hit ... " + testApi);
		response = given().get(testApi).then().statusCode(200).extract().response();
		System.out.println(response.asString());

	}

	@AfterClass
	public void shutDownServer() {
		if (server.isRunning() && null != server) {
			System.out.println("Shuting Down the Wiremock Server ....");
			server.shutdown();
		}
	}

}
