package simpleTests.functionalStyle;

import io.restassured.authentication.OAuthSignature;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class QueryWithAuth {
	//admin@pflb.ru
	//admin
	@Test
	void functionalStyleWithAuthentication() {
		String token =  given()
								.body("{\"username\" : \"user@pflb.ru\", \"password\" : \"user\"}")
								.header(new Header("Content-Type", "application/json"))
						.when()
								.post("http://77.50.236.203:4880/login")
								.body()
								.path("access_token");


		given()
				.auth()
				.oauth2(token, OAuthSignature.HEADER)
				.header(new Header("Content-Type", "application/json"))
				.get("http://77.50.236.203:4880/houses")
		.then()
				.statusCode(200);
	}
}
