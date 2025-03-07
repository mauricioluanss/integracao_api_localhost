package org.example.controller;
import org.example.repository.Body;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class Request {
    String uriRequest = "http://localhost:6060/Client/request";
    HttpClient client = HttpClient.newHttpClient();

    public int chamaPagamento(double value, String pm, String pt, String pmst) throws IOException, InterruptedException {
        Body json = new Body();
        String body = json.body(value, pm, pt, pmst);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.uriRequest))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }

    public void consultaPagamento() throws IOException, InterruptedException{

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:6060/Client/response"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        boolean status = true;
        do {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            if (response.statusCode() != 200) {
                System.out.print("Aguardando...\n");
                Thread.sleep(5000);
            } else if (response.statusCode() == 202){
                System.out.println(response.statusCode() + response.body());
                Thread.sleep(3000);
                status = false;
            } else {
                System.out.print(response.statusCode() + "\n" + response.body());
                break;
            }
        } while (status = true);

    }
}