package com.tw.ddd_workshop.domain;

import com.tw.ddd_workshop.domain.domain_service.PricingCalculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void addItemTest() {
        Product product = new Product("Apple Pencil", new Price(100));
        Cart cart = new Cart();

        Item item = new Item(product, 2);
        cart.add(item);

        assertNotNull(cart.getItems());
        assertEquals(2, cart.getItems().get(0).getQuantity());
    }

    @Test
    void removeItemTest() {
        Cart cart = new Cart();

        Item applePencil = new Item(new Product("Apple Pencil", new Price(100)), 2);
        Item headphone = new Item(new Product("Sony Wireless headphone", new Price(100)), 1);

        cart.add(applePencil);
        cart.add(applePencil);
        cart.add(headphone);

        assertEquals(3, cart.getItems().size());

        cart.remove(new Product("Apple Pencil", new Price(100)));

        assertNotNull(cart.getItems());
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void getRemovedProductNamesTest() {
        Cart cart = new Cart();

        Item applePencil = new Item(new Product("Apple Pencil", new Price(100)), 2);
        Item appleIPad = new Item(new Product("Apple iPad", new Price(100)), 2);
        Item headphone = new Item(new Product("Sony Wireless headphone", new Price(100)), 1);

        cart.add(applePencil);
        cart.add(appleIPad);
        cart.add(headphone);

        assertEquals(3, cart.getItems().size());

        cart.remove(new Product("Apple Pencil", new Price(100)));
        cart.remove(new Product("Sony Wireless headphone", new Price(100)));

        assertNotNull(cart.getItems());
        assertEquals(1, cart.getItems().size());

        List<String> removedProductNames = cart.getRemovedProductNames();

        assertEquals(2, removedProductNames.size());
        assertTrue(removedProductNames.containsAll(Arrays.asList("Apple Pencil", "Sony Wireless headphone")));

    }

    @Test
    void compareTwoCartsTest() {
        Item applePencil = new Item(new Product("Apple Pencil", new Price(100)), 2);
        Cart cartOne = new Cart();
        Cart cartTwo = new Cart();
        cartOne.add(applePencil);
        cartTwo.add(applePencil);

        assertNotEquals(cartOne, cartTwo);

    }

    @Test
    void addItemSonyHeadphoneTest() {
        String productName = "Sony Wireless headphone";
        Product product = new Product(productName, new Price(100));
        Cart cart = new Cart();

        Item item = new Item(product, 1);

        cart.add(item);

        assertNotNull(cart.getItems());
        assertEquals(1, cart.getItems().size());
        assertEquals(productName, cart.getItems().get(0).getProduct().getName());
    }

    @Test
    void emptyCartTest() {
        Cart cart = new Cart();

        assertNotNull(cart.getItems());
        assertEquals(0, cart.getItems().size());
    }
}