package com.aluracursos.exchangeconverter.models;

public class ExchangeUser {

    private String baseCode;
    private String targetCode;
    private double exchangeRate;
    private double amount;
    private double exchangeResult;

    public ExchangeUser(Exchange exchange, double amount) {

        if (exchange.result().contains("error")) {
            throw  new RuntimeException("Not a valid currency or amount");
        } else {
            this.baseCode = exchange.base_code();
            this.targetCode = exchange.target_code();
            this.exchangeRate = exchange.conversion_rate();
            this.amount = amount;
            this.exchangeResult = exchange.conversion_result();
        }
    }

    public String getBaseCode() {
        return baseCode;
    }

    public double getAmount() {
        return amount;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getExchangeResult() {
        return exchangeResult;
    }

    @Override
    public String toString() {
//        return  "(Base currency: '" + this.getBaseCode() + "', " +
//                "Target currency: " + this.getTargetCode() + ", " +
//                "Exchange rate: " + this.getExchangeRate() + ", " +
//                "Exchange amount: " + this.getAmount() + ", " +
//                "Exchange result: " + this.getExchangeResult() + ")";
        return  this.getAmount() +
                " [" + this.getBaseCode() + "] " +
                "at an exchange rate of " + this.getExchangeRate() +
                " [" + this.getTargetCode() + "] " +
                "is equivalent to " + this.getExchangeResult() + " [" + this.getTargetCode() + "].";
    }
}
