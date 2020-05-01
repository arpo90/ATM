package org.example.server;

import org.example.interaction.ValidateException;
import org.example.interaction.Request;
import org.example.interaction.Responce;
import org.example.server.product.Card;

import java.util.Map;
import java.util.TreeMap;

public class Host {
    private Map<String,Card> cards = new TreeMap<>();

    public Host(Card card) {
        this.cards.put(card.getNumber(),card);
    }

    public Responce getBalance(Request request){
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Responce(e.getCode(),e.getDesc());
        }
        return new Responce(cards.get(request.getNumber()).getAccount().getBalance());
    }

    private void validate(Request request) throws ValidateException {

        if (!cards.containsKey(request.getNumber())) {
            throw new ValidateException(3, "Error3");
        }

        Card card = cards.get(request.getNumber());

        if (card.getPIN() != request.getPIN()) {
            throw new ValidateException(2, "Error2");
        }

        if (!card.getExpDate().equals(request.getExpDate())) {
            throw new ValidateException(1, "Error1");
        }

    }


    @Override
    public String toString() {
        //todo: написать алгоритм форматирования строки и возврат получивщегося значения
        return "";
    }
}
