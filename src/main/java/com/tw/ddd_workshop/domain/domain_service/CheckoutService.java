package com.tw.ddd_workshop.domain.domain_service;

import com.tw.ddd_workshop.domain.Cart;
import com.tw.ddd_workshop.domain.Item;
import com.tw.ddd_workshop.domain.Order;
import com.tw.ddd_workshop.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public Order checkout(Cart cart) {
        List<Product> products = new ArrayList<>();
        for (Item item : cart.getItems()) {
            for (int i = 0; i < item.getQuantity(); i++) {
                products.add(item.getProduct());
            }
        }
        cart.checkout();
        return new Order(products);
    }
}
