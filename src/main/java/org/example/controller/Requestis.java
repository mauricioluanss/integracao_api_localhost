package org.example.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.repository.Body;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Requestis {
    String uriRequest = "http://localhost:6060/Client/request";


    public void chamaPagamento(double value, String pm, String pt, String pmst) throws IOException, InterruptedException {
        Body json = new Body();
        String body = json.body(value, pm, pt, pmst);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.uriRequest))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}