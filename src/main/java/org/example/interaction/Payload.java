package org.example.interaction;

import org.example.server.product.Balance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Optional;

@XmlRootElement(name = "Payload")
public class Payload {
    @XmlElement(name = "expDate")
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate expDate;
    @XmlElement(name = "number")
    private String number;
    @XmlElement(name = "PIN")
    private int PIN;

    public Payload() {
    }

    public Payload(LocalDate expDate, String number, int PIN) {
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
