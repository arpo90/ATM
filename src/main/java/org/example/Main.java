package org.example;

import org.example.interaction.Request;
import org.example.server.Host;
import org.example.server.product.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        /*Host host = new Host(
                new Card(
                        new Account(
                                new Balance(
                                        1
                                        , "USD"
                                )
                        )
                        , LocalDate.now()
                        , "1231111111"
                        , 123
                )
        );

        Card card = new Card(new Account(
                new Balance(
                        1
                        , "USD"
                )
        )
                , LocalDate.now()
                , "1231111111"
                , 123
        );

        try {
            Account account = card.getAccount(1);
            System.out.println(account.getBalance().getSum() + " " + account.getBalance().getCurrency());
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            System.out.println("false");
        }
        Optional<Account> acc = card.getAccountOptional(0);
        System.out.println(acc.isPresent());
        System.out.println(acc.orElseThrow(RuntimeException::new).getBalance().getSum() + " " + acc.orElseThrow(RuntimeException::new).getBalance().getCurrency());
        //    Optional<Account> acc1 = card.getAccountOptional(1);
        //    System.out.println(acc1.isPresent());
        //    System.out.println(acc1.orElseThrow(RuntimeException::new).getBalance().getSum() + " " + acc1.orElseThrow(RuntimeException::new).getBalance().getCurrency());
        //System.out.println(host);

        Map<String, Card> map = new TreeMap<>();
        map.put("1234 4321 1234 4321", new Card(new Account(
                new Balance(
                        1
                        , "USD"
                )
        )
                , LocalDate.now()
                , "1234 4321 1234 4321"
                , 123
        ));

        map.put("1111 1111 1111 1111", new Card(new Account(
                new Balance(
                        1
                        , "RUR"
                )
        )
                , LocalDate.now()
                , "1111 1111 1111 1111"
                , 123
        ));
        Object[] keySet = map.keySet().toArray();
        String res = "";
        for (int i = 0; i < keySet.length; i++) {
            if (res.equals("")) {
                res = "Cards Map size: " + map.size() + ".\n";// + Character.LINE_SEPARATOR;
            }
            res += "Card number: " + keySet[i] + ", Card ExpDate: " + map.get(keySet[i]).getExpDate() + "\n";
        }
        System.out.println(res);*/
        /*String filename = "test/Request.xml";
        Request request = new Request(LocalDate.now(), "1234 1234 1234 1234", 1234);
        request.convertObjectToXml(filename);

        Request request1 = (Request.fromXmlToObject(filename)).orElseThrow(RuntimeException::new);
        System.out.println(request.toString());

        System.out.println(AccountTypes.DEFAULT.ordinal());*/
    }

}
