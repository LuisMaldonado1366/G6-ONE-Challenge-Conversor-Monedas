package com.aluracursos.exchangeconverter.models;


import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeQuery {

    private final String token;

    private final HttpClient client = HttpClient.newHttpClient();

    public ExchangeQuery() {
        Dotenv dotenv = Dotenv.load();
        this.token = dotenv.get("EXCHANGE_TOKEN");
    }

    public Exchange queryExchange(String targetCurrency, String baseCurrency, double amount) throws IOException, InterruptedException {

        Exchange queriedExchange;

        String url = "https://v6.exchangerate-api.com/v6/" + this.token +
                "/pair/" + baseCurrency +"/"+targetCurrency+"/" + amount;

//        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        queriedExchange = new Gson().fromJson(response.body(), Exchange.class);

        return queriedExchange;
    }

    public String queryCurrencies() throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + this.token + "/codes";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(new Gson().fromJson(response.body(),  );

        return "hello";
    }

}
