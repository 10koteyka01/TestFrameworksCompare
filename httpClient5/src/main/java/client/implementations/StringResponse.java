package client.implementations;

import client.interfaces.Response;
import client.sut.models.house.House;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.jsonpath.JsonPath;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringResponse implements Response {
	private static Gson gson = new Gson();
	private int statusCode;
	private String reasonPhrase;
	private String content;

	public StringResponse(CloseableHttpResponse response) {
		statusCode = response.getCode();
		reasonPhrase = response.getReasonPhrase();
		try {
			content = EntityUtils.toString(response.getEntity());
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getBody() {
		return content;
	}

	@Override
	public <T> T getBodyAs(Class<T> type) {
		return gson.fromJson(content, type);
	}

	@Override
	public String getBodyParameterByName(String parameterName) {
		return JsonPath.parse(content).read("$.".concat(parameterName));
	}

	@Override
	public Response shouldBeStatusCode(int statusCode) {
		assertEquals(statusCode, this.statusCode);
		return this;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}


	public int getStatusCode() {
		return statusCode;
	}
}
