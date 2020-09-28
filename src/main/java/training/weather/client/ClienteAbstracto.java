package training.weather.client;

import java.io.IOException;
import java.util.logging.Logger;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class ClienteAbstracto {
	private String url;

	private static final Logger log = Logger.getLogger(ClienteAbstracto.class.getName());

	public ClienteAbstracto(String url) {
		this.url = url;
	}

	private String createEndpoint(String path) {
		String endpoint = url.concat(path);
		log.info(String.format("LLamando a endpoint %s", endpoint));
		return endpoint;
	}

	protected HttpRequest createClient(String path) {
		
		String pathEnsamblado = createEndpoint(path);
        
		HttpRequestFactory rf = new NetHttpTransport().createRequestFactory();
		HttpRequest req = null;
		try {
			req = rf
				.buildGetRequest(new GenericUrl(pathEnsamblado));
		} catch (IOException e) {
			log.severe(String.format("LLamando a endpoint %s", pathEnsamblado));
		}		
		return req;
	}

}
