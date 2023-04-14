package client.implementations;

import client.interfaces.Response;
import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.net.URI;

public class BaseMethods {
	private CloseableHttpClient client;
	//TODO дополнительная абстракция для Gson
	Gson gson = new Gson();
	public BaseMethods() {
		client = SimpleClientBuilder.getInstance().getClient();
	}

	public Response get(URI uri) {
		return execute(new HttpGet(uri));
	}

	public Response post(URI uri, Object body) {
		return post(uri, gson.toJson(body));
	}

	public Response post(URI uri, String body) {
		HttpUriRequest request = new HttpPost(uri);
		request.setEntity(new StringEntity(body));

		return execute(request);
	}

	private Response execute(HttpUriRequest request) {
		try {
			return new StringResponse(client.execute(request));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Не удалось отправить запрос");
		}
		return null;
	}
}
