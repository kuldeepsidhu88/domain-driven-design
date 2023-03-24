package com.tw.ddd_workshop.domain;

import java.util.*;

public class Cart {

    private final UUID uniqueIdentifier;

    private final List<Item> items;

    private final Set<Product> removedProducts;

    public boolean isCheckedOut() {
        return checkedOut;
    }

    private boolean checkedOut;

    public Cart() {
        items = new ArrayList<>();
        removedProducts = new HashSet<>();
        uniqueIdentifier = UUID.randomUUID();
        checkedOut = false;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Product product) {
        if (Objects.isNull(items) || items.isEmpty()) {
            return;
        }

        List<Item> itemsToRemove = items.stream().filter(item -> item.getProduct().equals(product)).toList();
        if (!itemsToRemove.isEmpty()) {
            items.removeAll(itemsToRemove);
            removedProducts.add(product);
        }
    }

    public List<String> getRemovedProductNames() {
        return removedProducts.stream().map(Product::getName).toList();
    }

    public void checkout() {
        this.checkedOut = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return checkedOut == cart.checkedOut && Objects.equals(uniqueIdentifier, cart.uniqueIdentifier) && Objects.equals(items, cart.items) && Objects.equals(removedProducts, cart.removedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueIdentifier, items, removedProducts, checkedOut);
    }
}
