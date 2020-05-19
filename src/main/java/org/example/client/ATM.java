package org.example.client;

import org.example.interaction.Payload;
import org.example.interaction.Request;
import org.example.server.Host;
import org.example.server.product.Balance;

import java.time.LocalDate;

public class ATM {
    Host host;

    public ATM(Host host) {
        this.host = host;
    }

    public Balance getBalance(LocalDate expDate, String number, int PIN) {

//        Request request = new Request(expDate, number, PIN);
//        Responce responce = host.getBalance(request);
//        Optional<Balance> balance = responce.getBalance();
//        return  balance.orElse();

        String filePath = "test/Request.xml";
        Request request = new Request(expDate, number, PIN);
        request.convertObjectToXml(filePath);

        return host.getBalanceFromXMLFile(filePath).getBalance().orElseThrow(RuntimeException::new);
        /*return host.getBalance(
                new Request(expDate, number, PIN)
        ).getBalance().orElse(new Balance(0, "USD"));*/
    }
}
