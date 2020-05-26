package org.example.interaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import java.util.Optional;

//todo: Подумать над рефакторингом класса org.example.interaction.JSONParser
public class JSONParser implements IntegrationParser {
    private static ObjectMapper mapper = new ObjectMapper();
    private static AnnotationIntrospector introspector
            = new JaxbAnnotationIntrospector();

    public JSONParser() {
        mapper.setAnnotationIntrospector(introspector);
    }

    @Override
    public Optional<String> saveObject(Object payload) {

        try {
            return Optional.of(mapper.writeValueAsString(payload));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Object> getObject(String payload, Class c) {
        try {
            return Optional.of(mapper.readValue(payload, c));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
