package com.tw.ddd_workshop.domain.domain_service;

import com.tw.ddd_workshop.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutServiceTest {

    @Test
    public void checkoutTest() {
        Cart cart = new Cart();
        Product product = new Product("Sony Wireless headphone", new Price(100));
        Item item = new Item(product, 2);

        Product product2 = new Product("Apple Pencil", new Price(100));
        Item item2 = new Item(product2, 2);

        cart.add(item);
        cart.add(item2);

        Order order = new CheckoutService().checkout(cart);

        assertTrue(cart.isCheckedOut());

        assertNotNull(order);
        assertEquals(4, order.getProducts().size());
    }

}