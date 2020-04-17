package org.example.client;

import org.example.interaction.Request;
import org.example.server.Host;
import org.example.server.product.Balance;

import java.time.LocalDate;

public class ATM {
    Host host;

    public ATM(Host host) {
        this.host = host;
    }

    public Balance getBalance(LocalDate expDate, int number, int PIN){

//        Request request = new Request(expDate, number, PIN);
//        Responce responce = host.getBalance(request);
//        Balance balance = responce.getBalance();
//        return  balance;

        return host.getBalance(
                new Request(expDate, number, PIN)
        ).getBalance();
    }
}
