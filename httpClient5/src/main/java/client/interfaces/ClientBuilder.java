package client.interfaces;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;

public interface ClientBuilder {
	CloseableHttpClient getClient();
}
