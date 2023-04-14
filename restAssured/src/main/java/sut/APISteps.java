package sut;

import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APISteps {

	public void login() {
		given()
				.body("{\"username\" : \"user@pflb.ru\", \"password\" : \"user\"}")
				.header(new Header("Content-Type", "application/json"))
				.when()
				.post("http://77.50.236.203:4880/login")
				.body()
				.path("access_token");
	}
}
