package client.implementations;

import client.interfaces.ClientBuilder;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.hc.core5.http.message.BasicHeader;

import java.util.ArrayList;

public class SimpleClientBuilder implements ClientBuilder {

	private CookieStore cookieStore = new BasicCookieStore();
	private static SimpleClientBuilder builder;

	private SimpleClientBuilder() {
	}

	public static SimpleClientBuilder getInstance() {
		if (builder == null) builder = new SimpleClientBuilder();
		return builder;
	}

	@Override
	public CloseableHttpClient getClient() {
		return HttpClients.custom()
				.setDefaultCookieStore(cookieStore)
				.setDefaultHeaders(new ArrayList<>() {{
					add(new BasicHeader("Content-Type", "application/json"));
				}})
				.build();
	}

	public void setToken(String token) {
		cookieStore.addCookie(new BasicClientCookie("Bearer", token));
	}
}
