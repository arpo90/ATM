package org.example.server.product;

public class Account {
    private Balance balance;

    public Account(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }
}
