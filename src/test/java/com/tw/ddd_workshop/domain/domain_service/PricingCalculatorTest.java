package com.tw.ddd_workshop.domain.domain_service;

import com.tw.ddd_workshop.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingCalculatorTest {

    @Test
    void discountedPriceTest() {
        String productName = "Apple Pencil";

        Map<String, Double> competitorPrices = new HashMap<>();
        competitorPrices.put("Apple Pencil", 10.0);

        PricingCalculator pricingCalculator = new PricingCalculator(competitorPrices);

        Product product = new Product(productName, pricingCalculator.calculatePrice(productName));

        assertEquals(9, product.getPrice().getAmount());

    }
}