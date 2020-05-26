package org.example.client;

import org.example.interaction.BalanceRequestPayload;
import org.example.interaction.BalanceResponsePayload;
import org.example.interaction.IntegrationParser;
import org.example.interaction.Request;
import org.example.server.Host;

import java.time.LocalDate;

//todo: В классе org.example.clien.ATM в методе
// getBalance как наилучшим образом обрабатывать
// ошибки (exeption) парсинга классов.
// Нужно клиентскому коду каким либо образом сообщать об ошибке компиляции.
// Клиентский код в данном случаи в классе org.example.Main

//todo: В классе org.example.clien.ATM добавить поля типа
// интерфейса из пункта 3 (на сайте КУ описано в такой последовательности.
// Задача с общим интерфейсом для классов парсеров).
// Инициализировать это поле в конструкторе класса ATM и добавить сеттер
// для изменения этого поля. Оно будет меняться на уровне класса org.example.Main
public class ATM {
    private Host host;
    private IntegrationParser integrationParser;

    public ATM(Host host, IntegrationParser integrationParcer) {
        this.host = host;
        this.integrationParser = integrationParcer;
    }

    public BalanceResponsePayload getBalance(LocalDate expDate, String number, int PIN) throws Exception {

//        Request request = new Request(expDate, number, PIN);
//        Responce responce = host.getBalance(request);
//        Optional<Balance> balance = responce.getBalance();
//        return  balance.orElse();

        String balanceRequestPayload = integrationParser.saveObject(
                new BalanceRequestPayload(expDate, number, PIN)).orElseThrow(Exception::new);

        Request request = new Request(balanceRequestPayload);

        BalanceResponsePayload balanceResponsePayload = (BalanceResponsePayload) integrationParser.getObject(
                host.getBalance(request).getPayload(), BalanceResponsePayload.class).orElseThrow(Exception::new);

        return balanceResponsePayload;
    }

    public void setIntegrationParser(IntegrationParser integrationParser) {
        this.integrationParser = integrationParser;
    }
}
