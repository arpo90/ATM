package org.example.interaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.time.LocalDate;
import java.util.Optional;

@XmlRootElement(name = "Request")
public class Request {
    @XmlElement(name = "payload")
    private String payload;

    public Request(LocalDate expDate, String number, int PIN) {
        //this.payload = new BalancePayload(expDate, number, PIN);
    }

    public Request(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public static Optional<Request> fromXmlToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Request.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            Request request = (Request) un.unmarshal(new File(filePath));
            return Optional.of(request);
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public void convertObjectToXml(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Request.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "ExpDate=" + this.payload.getExpDate() +
                ", Number='" + this.payload.getNumber() + '\'' +
                ", PIN=" + this.payload.getPIN() +
                '}';
    }
}
