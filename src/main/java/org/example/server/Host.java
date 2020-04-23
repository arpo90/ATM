package org.example.server;

import org.example.interaction.ValidateException;
import org.example.interaction.Request;
import org.example.interaction.Responce;
import org.example.server.product.Card;

public class Host {
    private Card card;

    public Host(Card card) {
        this.card = card;
    }

    public Responce getBalance(Request request){
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Responce(e.getCode(),e.getDesc());
        }
        return new Responce(card.getAccount().getBalance());
    }

    private void validate(Request request) throws ValidateException {

        if (card.getNumber() != request.getNumber()) {
            throw new ValidateException(3,"Error3");
        }

        if (card.getPIN() != request.getPIN()) {
            throw new ValidateException(2,"Error2");
        }

        if (!card.getExpDate().equals(request.getExpDate())){
            throw new ValidateException(1,"Error1");
        }
    }


    @Override
    public String toString() {
        return card.getAccount().getBalance().getCurrency();
    }
}
