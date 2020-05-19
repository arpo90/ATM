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
public class Request extends Payload {
    @XmlElement(name = "SomeXMLData")
    private String someXMLData = "SomeData";

    public Request(LocalDate expDate, String number, int PIN) {
        super(expDate, number, PIN);
    }

    public Request() {
        super();
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
                "ExpDate=" + super.getExpDate() +
                ", Number='" + super.getNumber() + '\'' +
                ", PIN=" + super.getPIN() +
                '}';
    }
}
