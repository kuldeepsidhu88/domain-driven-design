package com.tw.ddd_workshop.domain.bank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {

    @Test
    public void updateAddressTest() {
        Address address = new Address("Bangalore");
        Account account1 = new Account(address);
        Account account2 = new Account(address);

        Customer customer = new Customer(Arrays.asList(account1, account2), address);

        Address mumbai = new Address("Mumbai");
        customer.updateAddress(mumbai);

        assertEquals(mumbai, customer.getAddress());
        List<Address> addresses = customer.getAccounts().stream().map(Account::getAddress).toList();
        assertTrue(addresses.containsAll(Arrays.asList(mumbai)));
    }
}