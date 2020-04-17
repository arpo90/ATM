package org.example.interaction;

import java.time.LocalDate;

public class Request {
    private LocalDate expDate;
    private int number;
    private int PIN;

    public Request(LocalDate expDate, int number, int PIN) {
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
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
