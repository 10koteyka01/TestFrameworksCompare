package client.sut;

import client.implementations.SimpleClientBuilder;
import client.interfaces.Response;
import client.sut.models.User;

public class APISteps {
	public void login() {
		User user = new User("user@pflb.ru", "user");
		Response response = new APISpecification().login(user);

		SimpleClientBuilder.getInstance().setToken(response.getBodyParameterByName("access_token"));
	}
}
