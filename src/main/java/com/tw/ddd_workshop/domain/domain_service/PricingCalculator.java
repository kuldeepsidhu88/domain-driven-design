package com.tw.ddd_workshop.domain.domain_service;

import com.tw.ddd_workshop.domain.Price;

import java.util.Map;

public class PricingCalculator {

    private Map<String, Double> competitorPrices;

    public PricingCalculator(Map<String, Double> competitorPrices) {
        this.competitorPrices = competitorPrices;
    }

    public Price calculatePrice(String productName) {
        Double competitorPrice = competitorPrices.get(productName);
        return new Price(competitorPrice).reduceBy(0.1);
    }
}
