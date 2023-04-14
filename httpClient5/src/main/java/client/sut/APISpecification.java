package client.sut;

import client.implementations.BaseMethods;
import client.interfaces.Response;
import client.sut.models.User;

import static utils.UriBuilder.getURI;

public class APISpecification {
	BaseMethods base = new BaseMethods();

	public Response login(User user) {
		return base.post(getURI("login"), user);
	}

	public Response getHouses() {
		return base.get(getURI("houses"));
	}
}
