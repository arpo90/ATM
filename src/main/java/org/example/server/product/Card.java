package org.example.server.product;


import java.time.LocalDate;

public class Card {
    private Account account;
    private LocalDate expDate;
    private int number;
    private int PIN;

    public Card(Account account, LocalDate expDate, int number, int PIN) {
        this.account = account;
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public int getNumber() {
        return number;
    }

    public int getPIN() {
        return PIN;
    }
}
