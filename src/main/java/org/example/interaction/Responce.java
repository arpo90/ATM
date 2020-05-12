package org.example.interaction;

import org.example.server.product.Balance;

import java.util.Optional;

public class Responce {
    private Balance balance;
    private int code;
    private String desc;


    public Responce(Balance balance) {
        this.balance = balance;
        this.code = 0;
        this.desc = "Ok";
    }

    public Responce(int code, String desc) {
        this.code = code;
        this.desc = desc;

        this.balance = null;
    }

    public Optional<Balance> getBalance() {
        return Optional.ofNullable(balance);
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
