package org.example.server.product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Balance")
public class Balance {
    @XmlElement(name = "sum")
    private int sum;
    @XmlElement(name = "currency")
    private String currency;

    public Balance(int sum, String currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public int getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }
}
