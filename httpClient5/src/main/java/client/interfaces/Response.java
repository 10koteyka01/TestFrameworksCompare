package client.interfaces;

public interface Response {
	String getBody();

	<T> T getBodyAs(Class<T> type);

	String getBodyParameterByName(String parameterName);

	Response shouldBeStatusCode(int statusCode);
}
