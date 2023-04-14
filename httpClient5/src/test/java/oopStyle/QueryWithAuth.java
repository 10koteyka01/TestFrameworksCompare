package oopStyle;

import client.sut.APISpecification;
import client.sut.APISteps;
import client.sut.models.house.House;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QueryWithAuth {

	APISpecification api = new APISpecification();

	@BeforeAll
	public static void beforeAll() {
		new APISteps().login();
	}

	@Test
	void getHouses() {
		House[] houses = api.getHouses().shouldBeStatusCode(200).getBodyAs(House[].class);
		assertNotNull(houses);
	}
}
