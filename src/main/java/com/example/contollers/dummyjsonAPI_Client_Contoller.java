package com.example.contollers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Inject;

import java.io.IOException;

@Controller("api")
public class dummyjsonAPI_Client_Contoller {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Inject
    public dummyjsonAPI_Client_Contoller(@Client("https://dummyjson.com") HttpClient httpClient,
                                         ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Get
    public String getUsers() throws IOException {
        HttpRequest<?> request = HttpRequest.GET("/users");
        HttpResponse<String> response = httpClient.toBlocking().exchange(request, String.class);
        String responseBody = response.body();
        System.out.println("✅");

        return responseBody;
    }


}
