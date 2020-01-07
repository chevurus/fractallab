package com.example.fractallab.service;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.example.fractallab.model.Token;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateHeaderModifierInterceptor.class);

	@Value("${fractal.token.api.url}")
	private String tokenApiUrl;

	@Value("${fractal.myApp.xApiKey}")
	private String xApiKey;

	@Value("${fractal.myApp.xPartnerId}")
	private String xPartnerId;

	// stores access token
	private static String accessToken = null;

	private static final String AUTHORIZATION = "Authorization";

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {

		if (accessToken == null) {
			accessToken = fetchAccessToken();
		}

		request.getHeaders().set("Accept", "application/json");
		request.getHeaders().set("Content-Type", "application/json");
		request.getHeaders().set("X-Api-Key", xApiKey);
		request.getHeaders().set("X-Partner-Id", xPartnerId);
		request.getHeaders().set("Authorization", "Bearer " + accessToken);

		ClientHttpResponse response = execution.execute(request, body);
		LOGGER.info("ClientResponse:[{}], status|{}", "BASIC", response.getStatusCode());

		if (HttpStatus.UNAUTHORIZED == response.getStatusCode()) {
			String newAccessToken = fetchAccessToken();
			if (!StringUtils.isEmpty(accessToken)) {
				request.getHeaders().remove(AUTHORIZATION);
				request.getHeaders().add(AUTHORIZATION, "Bearer " + newAccessToken);

				// retry
				response = execution.execute(request, body);
			}
		}
		return response;
	}

	private String fetchAccessToken() {

		HttpHeaders headers = new HttpHeaders();
		headers = setHeader(headers);

		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Token> result = restTemplate.exchange(tokenApiUrl, HttpMethod.POST, entity, Token.class);
		// And Thereby fetching 'access_token' from the successful fetch.

		Token token = result.getBody();

		LOGGER.info("Token fetched from URI:" + token.getAccessToken());

		return token.getAccessToken();

	}

	private HttpHeaders setHeader(HttpHeaders headers) {

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Api-Key", xApiKey);
		headers.set("X-Partner-Id", xPartnerId);
		return headers;

	}

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
		accessToken = accessToken;
	}

}