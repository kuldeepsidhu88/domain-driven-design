package com.tw.ddd_workshop.domain.bank;

import java.util.List;
import java.util.UUID;

public class Customer {
    private UUID id;
    private List<Account> accounts;
    private Address address;

    public Customer(List<Account> accounts, Address address) {
        this.id = UUID.randomUUID();
        this.accounts = accounts;
        this.address = address;
    }

    public void updateAddress(Address address) {
        this.address = address;
        this.accounts.forEach(account -> account.setAddress(address));
    }

    public Address getAddress() {
        return address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
