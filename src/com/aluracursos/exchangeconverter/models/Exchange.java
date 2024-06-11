package com.aluracursos.exchangeconverter.models;

public record Exchange(String result, String base_code, String target_code, double conversion_rate, double conversion_result) {

}
