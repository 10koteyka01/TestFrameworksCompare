package utils;

import org.apache.hc.core5.net.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class UriBuilder {
	public static URI getURI(String path) {
		try {
			return new URIBuilder("http://77.50.236.203:4880/").setPath(path).build();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
}
