package com.bragado.EmailSystem.components;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestService {

    private RestService() {}
    public static <T> T call(UriComponentsBuilder builder, HttpMethod method, Class<T> responseType) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<T> response = restTemplate.exchange(
                builder.toUriString(),
                method,
                entity,
                responseType);

        return response.getBody();
    }
}
