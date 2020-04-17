package org.example.server;

import org.example.interaction.Error;
import org.example.interaction.Request;
import org.example.interaction.Responce;
import org.example.server.product.Card;

import java.time.LocalDate;

public class Host {
    private Card card;

    public Host(Card card) {
        this.card = card;
    }

    public Responce getBalance(Request request){
        Responce responce;
        if (card.getNumber() == request.getNumber()) {
            if (card.getPIN() == request.getPIN()) {
                if (card.getExpDate().equals(request.getExpDate())){

                    responce = new Responce(card.getAccount().getBalance());
                } else {
                    responce = new Responce(new Error(1,"Error1"));
                }
            }else {
                responce = new Responce(new Error(2,"Error2"));
            }
        }else {
            responce = new Responce(new Error(3,"Error3"));
        }

        return responce;
    }



    @Override
    public String toString() {
        return card.getAccount().getBalance().getCurrency();
    }
}
