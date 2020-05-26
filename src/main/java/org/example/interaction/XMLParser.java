package org.example.interaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Optional;

// todo: Привести классы org.example.interaction.XMLParser
//  и org.example.interaction.JSONParser к одному интерфейсу т.е.
//  сделать так чтобы сигнатуры их методов (названия методов и типы их аргементов)
//  совпадали. Нужно создать новый интерфейс и описать в нем эти методы,
//  а потом сделать так чтобы классы расширяли этот интерфейс.
public class XMLParser implements IntegrationParser {
    @Override
    public Optional<Object> getObject(String xmlString, Class c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return Optional.of(unmarshaller.unmarshal(new StringReader(xmlString)));
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> saveObject(Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();

            StringWriter result = new StringWriter();
            marshaller.marshal(o, result);
            return Optional.of(result.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
