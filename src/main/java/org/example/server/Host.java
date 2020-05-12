package org.example.server;

import org.example.interaction.Request;
import org.example.interaction.Responce;
import org.example.interaction.ValidateException;
import org.example.server.product.Account;
import org.example.server.product.AccountNotFoundException;
import org.example.server.product.Card;

import java.util.Map;
import java.util.TreeMap;

public class Host {
    private Map<String, Card> cards = new TreeMap<>();

    public Host(Card card) {
        this.cards.put(card.getNumber(), card);
    }

    public Responce getBalance(Request request) {
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Responce(e.getCode(), e.getDesc());
        }

        Account account;

        try {
            account = cards.get(request.getNumber()).getAccount(0);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            return new Responce(e.getCode(), e.getDesc());
        }

        return new Responce(account.getBalance());
        /*
        Optional<Account> acc = cards.get(request.getNumber()).getAccountOptional(0);

        if(acc.isPresent()){
            return new Responce(acc.get().getBalance());
        }else {
            return new Responce(1, "Account not found");
        }
        */
    }

    public void addCard(Card card) {
        this.cards.put(card.getNumber(), card);
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
        String result = "";
        Object[] keySet = cards.keySet().toArray();
        for (Object o : keySet) {
            if (result.equals("")) {
                result = "Cards Map size: " + cards.size() + ".\n";// + Character.LINE_SEPARATOR;
            }
            result += "Card number: " + o + ", Card ExpDate: " + cards.get(o).getExpDate() + "\n";
        }
        return result;
    }
}
