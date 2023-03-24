package com.tw.ddd_workshop.domain;

import java.util.Currency;
import java.util.Objects;

public class Price {
    private double amount;
    private Currency currency;

    public Price(double amount) {
        this.amount = amount;
        this.currency = Currency.getInstance("USD");
    }

    public Price reduceBy(double discount) {
        return new Price(amount - amount * discount);
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return amount == price.amount && Objects.equals(currency, price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
