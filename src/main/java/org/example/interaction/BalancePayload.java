package org.example.interaction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement(name = "Balance_Payload")
public class BalancePayload {
    @XmlElement(name = "expDate")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate expDate;
    @XmlElement(name = "number")
    private String number;
    @XmlElement(name = "PIN")
    private int PIN;

    public BalancePayload() {
    }

    public BalancePayload(LocalDate expDate, String number, int PIN) {
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
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
