package com.aluracursos.exchangeconverter.main;

import com.aluracursos.exchangeconverter.models.Exchange;
import com.aluracursos.exchangeconverter.models.ExchangeQuery;
import com.aluracursos.exchangeconverter.models.ExchangeUser;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExchangeQuery exchangeQuery = new ExchangeQuery();

        while (true) {



            try {
                String data = exchangeQuery.queryCurrencies();
                System.out.println(data);


                Scanner userInput = new Scanner(System.in);
                System.out.println("Enter the value to convert: ");

                String userOption = userInput.nextLine();
                if (userOption.equalsIgnoreCase("q")) {
                    break;
                }
                double amount = Double.parseDouble(userOption);

                Exchange exchangeCurrency = exchangeQuery.queryExchange("MXN", "USD", amount);

                if (exchangeCurrency.result().equalsIgnoreCase("error")) {
                    System.out.println("Not a valid conversion.");

                } else {

                    ExchangeUser exchangeUser = new ExchangeUser(exchangeCurrency, amount);
                    System.out.println(exchangeUser);
                }

            } catch (IOException | InterruptedException e) {

                System.out.println("Exit on error - " + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println("Enter a valid amount!");

            }

        }
        System.out.println("\n\n\nProgram terminated.");
    }
}
