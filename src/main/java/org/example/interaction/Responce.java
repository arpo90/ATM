package org.example.interaction;

import org.example.server.product.Balance;

public class Responce {
    private Balance balance;
    private Error error;

    public Responce(Balance balance) {
        this.balance = balance;
        this.error = new Error();
    }

    public Responce(Error error) {
        this.error = error;
        this.balance = null;
    }

    public Balance getBalance() {
        return balance;
    }

    public Error getError() {
        return error;
    }
}
