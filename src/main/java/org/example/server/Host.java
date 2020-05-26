package org.example.server;

import org.example.interaction.*;
import org.example.server.product.Account;
import org.example.server.product.AccountTypes;
import org.example.server.product.Balance;
import org.example.server.product.Card;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Host {
    private Map<String, Card> cards = new TreeMap<>();
    private IntegrationParser integrationParser;

    public Host(Card card, IntegrationParser integrationParcer) {
        this.integrationParser = integrationParcer;
        this.cards.put(card.getNumber(), card);
    }

    public void setIntegrationParser(IntegrationParser integrationParser) {
        this.integrationParser = integrationParser;
    }

    public Response getBalance(Request request) {
        BalanceRequestPayload balancePayload;

        try {
            Optional<Object> objectPayload = integrationParser.getObject(request.getPayload(), BalanceRequestPayload.class);
            balancePayload = (BalanceRequestPayload) objectPayload.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(2, "Parse Exception");
        }

        try {
            validate(balancePayload);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Response(e.getCode(), e.getDesc());
        }

        try {
            Optional<Account> acc = cards.get(balancePayload.getNumber()).getAccountOptional(AccountTypes.DEFAULT.ordinal());
            Balance balance = acc.orElseThrow(RuntimeException::new).getBalance();
            BalanceResponsePayload balanceResponsePayload = new BalanceResponsePayload(balance.getSum(), balance.getCurrency());
            return new Response(integrationParser.saveObject(balanceResponsePayload).orElseThrow(Exception::new));
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "Account not found");
        }
    }

    public void addCard(Card card) {
        this.cards.put(card.getNumber(), card);
    }

    private void validate(BalanceRequestPayload balancePayload) throws ValidateException {

        if (!cards.containsKey(balancePayload.getNumber())) {
            throw new ValidateException(3, "Error3");
        }

        Card card = cards.get(balancePayload.getNumber());

        if (card.getPIN() != balancePayload.getPIN()) {
            throw new ValidateException(2, "Error2");
        }

        if (!card.getExpDate().equals(balancePayload.getExpDate())) {
            throw new ValidateException(1, "Error1");
        }

    }


    @Override
    public String toString() {
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
