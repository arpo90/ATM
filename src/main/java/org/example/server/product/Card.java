package org.example.server.product;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Card {
    private List<Account> accounts = new ArrayList<>();
    private LocalDate expDate;
    private String number;
    private int PIN;

    public Card(Account account, LocalDate expDate, String number, int PIN) {

        this.accounts.add( account);

        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }

    public Account getAccount(int indx) {
        if(accounts.size() <= indx) {
            //sfgss
        }
        return accounts.get(indx);

//        Account account = new Account(new Balance(1,"USD"));
//        try{
//            account = accounts.get(indx);
//        }catch (IndexOutOfBoundsException outOfBoundsException)
//        {
//            log.error("gwgsdfgssg");
//        }finally {
//
//        }
//        return account;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getNumber() {
        return number;
    }

    public int getPIN() {
        return PIN;
    }
}
