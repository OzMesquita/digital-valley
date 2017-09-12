package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestHttpModule {
	public static String executeHTTPRequestToModule(String url, String jsonUser) throws IOException {		
		// prepare json
		StringEntity input = new StringEntity(jsonInstanceContent);
		input.setContentType("application/json");
		// prepare http request
		HttpPost postRequest = new HttpPost(url);
		postRequest.setEntity(input);
		HttpClient httpClient = HttpClientBuilder.create().build();
		// do request and prepare response
		HttpResponse response = httpClient.execute(postRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		// prepare output
		StringBuilder totalOutput = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		while ((output = br.readLine()) != null) {
			totalOutput.append(output);
		}
		return totalOutput.toString();
	}
}
