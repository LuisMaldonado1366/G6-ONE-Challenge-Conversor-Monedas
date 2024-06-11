package com.aluracursos.exchangeconverter.main;

import com.aluracursos.exchangeconverter.models.Currency;
import com.aluracursos.exchangeconverter.models.ExchangeQuery;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("EXCHANGER_TOKEN");

        try {
        Scanner userInput = new Scanner(System.in);
        ExchangeQuery exchangeQuery = new ExchangeQuery();

        Currency exchangeCurrency = exchangeQuery.queryExchange("MXN", "USD", 2.0);
            System.out.println(exchangeCurrency);
            } catch (IOException | InterruptedException e) {
                        System.out.println("Exit on error - " + e.getMessage());
        }
    }
}
