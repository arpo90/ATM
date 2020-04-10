package org.example;

import java.time.LocalDate;

public class Host {
    private Card card;

    public Host(Card card) {
        this.card = card;
    }

    public Balance getBalance(LocalDate expDate, int number, int PIN){
        if (card.getNumber() == number) {
            if (card.getPIN() == PIN) {
                if (card.getExpDate().equals(expDate)){

//                    для сравнения подходов
//                    Account account = card.getAccount();
//                    Balance balance = account.getBalance();
//                    return balance;

                    return card.getAccount().getBalance();
                }
            }
        }
    }
}
