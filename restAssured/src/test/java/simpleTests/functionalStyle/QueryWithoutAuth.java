package simpleTests.functionalStyle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryWithoutAuth {

	@Test
	void functionalStyleWithoutAuthentication() {
		when().
				get("http://77.50.236.203:4833/").
		then().
				statusCode(200);
	}

	@Test
	void hflshjdfklsw() {
		assertEquals("1", "1");
	}

}
