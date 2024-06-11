package com.aluracursos.exchangeconverter.models;


import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeQuery {

    public Currency queryExchange(String targetCurrency, String baseCurrency, double amount) throws IOException, InterruptedException {

        Currency queriedExchange;
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("EXCHANGER_TOKEN");

        String url = "https://v6.exchangerate-api.com/v6/" + token +
                "/pair/" + baseCurrency +"/"+targetCurrency+"/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            queriedExchange = new Gson().fromJson(response.body(), Currency.class);

            return queriedExchange;
    }
}
