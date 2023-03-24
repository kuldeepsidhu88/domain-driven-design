package com.tw.ddd_workshop.domain.bank;

import java.util.UUID;

public class Account {

    private UUID id;
    private Address address;

    public Account(Address address) {
        this.id = UUID.randomUUID();
        this.address = address;
    }

    protected void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
